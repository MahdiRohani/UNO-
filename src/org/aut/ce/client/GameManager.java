package org.aut.ce.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager implements Serializable {

    private static ArrayList<Card> gameCards = new ArrayList<>();
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Card> penaltyCards = new ArrayList<>();
    private static Card boardCard;
    private static Color boardColor;




    public static void addPlayer(Player playerToAdd) {
        players.add(playerToAdd);
    }


    public static Player getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }


    public static ArrayList<Player> getPlayers()
    {
        return players;
    }


    public static void distributeCards() {
        for (int n = 0; n < 7; n++) {
            for (Player p : players) {
                p.addCard(gameCards.get(0));
                gameCards.remove(0);
            }
        }
        while (!(gameCards.get(0) instanceof NumberCard)) {
            boardCard = gameCards.get(0);
            gameCards.remove(0);
            gameCards.add(boardCard);
        }

        boardCard = gameCards.remove(0);
        boardColor = Color.getBackgroundColor(boardCard.getCardColor());
        gameCards.remove(0);
    }


    public static boolean checkChoose(Card playerChosenCard, Player player) {
        if (playerChosenCard instanceof WildColorCard)
            return true;
        if (playerChosenCard instanceof WildDraw4Card) {
            for (Card card : player.getPlayerCards()) {
                if (card instanceof WildDraw4Card)
                    continue;

                if (checkChoose(card, player))
                    return false;
            }

            return true;
        }
        if (boardCard instanceof Draw2Card && penaltyCards.size() != 0) {
            return playerChosenCard instanceof Draw2Card;
        }


        // revers card case
        if (boardCard instanceof ReverseCard && playerChosenCard instanceof ReverseCard)
            return true;

        if (Color.getBackgroundColor(playerChosenCard.getCardColor()) == boardColor)
            return true;

        if (playerChosenCard instanceof NumberCard && boardCard instanceof NumberCard)
            if (playerChosenCard.getCardScore() == boardCard.getCardScore())
                return true;
        return playerChosenCard instanceof SkipCard && boardCard instanceof SkipCard;
    }


    public static void applyChoose(Card playerChosenCard, Color chosenColor) {
        changeBoardCard(playerChosenCard);
        boardColor = Color.getBackgroundColor(chosenColor);


        if (playerChosenCard instanceof WildDraw4Card) {
            for (int n = 0; n < 4; n++) {
                penaltyCards.add(gameCards.get(0));
                gameCards.remove(0);
            }
        } else if (playerChosenCard instanceof Draw2Card) {
            for (int n = 0; n < 2; n++) {
                penaltyCards.add(gameCards.get(0));
                gameCards.remove(0);
            }
        }
    }


    public static void runGame(Scanner inputs)
    {

        Player currentPlayer;
        int currentPlayerIndex = firstPlayer();
        Card playerChosenCard;
        String holdInput;
        Bot bot;


        while (!endGame())
        {
            // set the current player
            currentPlayer = players.get(currentPlayerIndex);


            // get the penalty cards
            // while the player enter his/her password
            if (!(currentPlayer instanceof Bot))
            {
                while (true)
                {
                    // ask the player password
                    Print.getPassToStartTurn(currentPlayer);
                    holdInput = inputs.nextLine();

                    // check player input
                    if (currentPlayer.getPlayerPass().equals(holdInput))
                        break;

                    // say that player input is incorrect
                    Print.inValidInputError(inputs);
                }
            }


            // the draw2 case
            if (penaltyCards.size() != 0)
            {
                boolean check = false;
                for (Card card: currentPlayer.getPlayerCards())
                {
                    if (card instanceof Draw2Card)
                    {
                        check = true;
                        break;
                    }
                }

                if (!check)
                {
                    int n = penaltyCards.size();
                    for (; n > 0; n--)
                    {
                        currentPlayer.addCard(penaltyCards.get(0));
                        penaltyCards.remove(0);
                    }
                }

                // go to the next player
                currentPlayerIndex = ((currentPlayerIndex+1)%players.size());
                continue;
            }


            // check the player cards
            if (!checkPlayerCards(currentPlayer))
            {
                // get a card to player
                giveCardToPlayer(currentPlayer);
                // check the player cards again
                if (!checkPlayerCards(currentPlayer))
                {
                    // show the board, number of the other players cards and current player cards
                    Print.printGameBoard(boardCard, boardColor);
                    Print.printNumberOfPlayersCards(players, currentPlayerIndex );
                    Print.printPlayerCards(currentPlayer);
                    // say to player that he/she can't choose any card
                    if (!(currentPlayer instanceof Bot))
                        Print.noChoiceError(inputs);

                    // go to the next player
                    currentPlayerIndex = ((currentPlayerIndex+1)%players.size());
                    continue;
                }
            }

            if (currentPlayer instanceof Bot)
            {
                bot = (Bot)currentPlayer;

                playerChosenCard = bot.playTurn(players,  penaltyCards, currentPlayerIndex);


                // go to the next player
                currentPlayerIndex = setIndex(playerChosenCard, currentPlayerIndex);
                continue;
            }

            // while player choose a valid card
            while (true)
            {
                // while player choose a valid card code
                while (true)
                {
                    // show the board, number of the other players cards and current player cards
                    Print.printGameBoard(boardCard, boardColor);
                    Print.printNumberOfPlayersCards(players, currentPlayerIndex );
                    Print.printPlayerCards(currentPlayer);
                    // ask the player choice
                    Print.getPlayerChoice(currentPlayer);
                    holdInput = inputs.nextLine();
                    // check player choice
                    if (holdInput.length() > 0 && holdInput.length() < 4 && isInt(holdInput))
                        if (Integer.parseInt(holdInput) <= 108  &&  Integer.parseInt(holdInput) > 0)
                            if (currentPlayer.haveCard(Integer.parseInt(holdInput)))
                                break;

                    // say that player input is incorrect
                    Print.inValidInputError(inputs);
                }
                // get player chosen card
                playerChosenCard = currentPlayer.removeCard(Integer.parseInt(holdInput));
                // check the player chosen card
                if (checkChoose(playerChosenCard, currentPlayer))
                {
                    if (playerChosenCard instanceof WildColorCard || playerChosenCard instanceof WildDraw4Card)
                    {

                        while (true)
                        {
                            // ask the player chosen color
                            Print.getPlayerChosenColor();
                            holdInput = inputs.nextLine();
                            // check the player input
                            if (holdInput.length() == 1 && holdInput.charAt(0) > '0' && holdInput.charAt(0) < '5')
                                break;

                            // say that player input is incorrect
                            Print.inValidInputError(inputs);
                            // show the board, number of the other players cards and current player cards
                            Print.printGameBoard(boardCard, boardColor);
                            Print.printNumberOfPlayersCards(players, currentPlayerIndex );
                            Print.printPlayerCards(currentPlayer);
                        }

                        switch (holdInput) {
                            case "1" -> applyChoose(playerChosenCard, Color.RED);
                            case "2" -> applyChoose(playerChosenCard, Color.YELLOW);
                            case "3" -> applyChoose(playerChosenCard, Color.GREEN);
                            case "4" -> applyChoose(playerChosenCard, Color.BLUE);
                        }

                    }

                    else
                        applyChoose(playerChosenCard, playerChosenCard.getCardColor());

                    break;
                }
                // give back the card to the player
                currentPlayer.addCard(playerChosenCard);
                // say that player input is incorrect
                Print.inValidInputError(inputs);
            }

            // wild draw case
            if (playerChosenCard instanceof WildDraw4Card)
            {
                int index = (currentPlayerIndex+1)%players.size();
                int n = penaltyCards.size();

                for (; n > 0; n--)
                {
                    players.get(index).addCard(penaltyCards.get(0));;
                    penaltyCards.remove(0);
                }
            }


            // go to the next player
            currentPlayerIndex = setIndex(playerChosenCard, currentPlayerIndex);
        }

        sortPlayers();
        Print.printScores(players, inputs);
    }

    private static int setIndex(Card playerChosenCard, int currentPlayerIndex)
    {
        // skip card case
        if (playerChosenCard instanceof SkipCard || playerChosenCard instanceof WildDraw4Card)
            currentPlayerIndex = currentPlayerIndex+2;

            // reverse card case
        else if (playerChosenCard instanceof ReverseCard)
        {
            reversePlayers();
            currentPlayerIndex = (players.size() - currentPlayerIndex);
        }

        // finish one round case
        else if (currentPlayerIndex+1 == players.size())
            currentPlayerIndex = 0;


            // other cases
        else
            currentPlayerIndex++;




        return (currentPlayerIndex%players.size());
    }

    private static boolean endGame() {
        for (Player player : players) {
            if (player.getNumberOfPlayerCards() == 0)
                return true;
        }

        return false;
    }


    private static void suffleCards() {
        ArrayList<Integer> suffledCards = new ArrayList<>();

        Card holdCard;

        Random rand = new Random();

        int randNum1 = 0, randNum2 = 0;


        for (int n = 0; n < 40; n++) {
            //   * generate the first random number *
            // while find a valid number
            do {
                // generate the random number
                randNum1 = rand.nextInt(108);

                // check the generated number
            } while (suffledCards.contains(randNum1));
            suffledCards.add(randNum1);


            //   * generate the second random number *
            // while find a valid number
            do {
                // generate the random number
                randNum2 = rand.nextInt(108);

                // check the generated number
            } while (suffledCards.contains(randNum2) || randNum2 == randNum1);
            suffledCards.add(randNum2);

            // swap the cards
            holdCard = gameCards.get(randNum1);
            gameCards.set(randNum1, gameCards.get(randNum2));
            gameCards.set(randNum2, holdCard);
        }
    }

    private static boolean isInt(String stringToCheck)
    {
        for (int n = 0; n < stringToCheck.length(); n++)
        {
            if (!('0' <= stringToCheck.charAt(n) && stringToCheck.charAt(0) <= '9'))
                return false;
        }

        return true;
    }






    private static void reversePlayers() {
        // hold the player for swap
        Player holdPlayer;

        for (int first = 0, end = players.size() - 1; first < players.size() / 2; first++, end--) {
            holdPlayer = players.get(first);
            players.set(first, players.get(end));
            players.set(end, holdPlayer);
        }
    }

    private static int firstPlayer() {
        Random rand = new Random();
        return rand.nextInt(players.size());
    }




    public static void reset()
    {
        players = new ArrayList<>();
        gameCards = new ArrayList<>();
        penaltyCards = new ArrayList<>();
    }


    private static boolean checkPlayerCards(Player player)
    {
        for (Card card: player.getPlayerCards())
        {
            if (checkChoose(card, player))
                return true;
        }

        return false;
    }



    // this method give a card to player from game cards
    private static void giveCardToPlayer(Player currentPlayer)
    {
        currentPlayer.addCard(gameCards.get(0));
        gameCards.remove(0);
    }




    // this method sort the players by their scores
    private static void sortPlayers()
    {
        // hold the player for swap
        Player holdPlayer;

        for (int i = 0; i < players.size(); i++)
            for (int j = i; j < players.size(); j++)
                if (players.get(i).getScore() > players.get(j).getScore())
                {
                    holdPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, holdPlayer);
                }
                else if (players.get(i).getScore() == players.get(j).getScore()
                        &&
                        (players.get(i).getNumberOfPlayerCards() > players.get(j).getNumberOfPlayerCards()))
                {
                    holdPlayer = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, holdPlayer);
                }
    }

    private static void changeBoardCard(Card newCard)
    {
        gameCards.add(boardCard);
        boardCard = newCard;
    }

    public boolean logIn(Player player) {
        for (Player value : players) {
            if (player.equals(value)) {
                System.out.println("Player already exists!!!");
                return false;
            }
        }
        System.out.println("player logged in successfully!!!");
        players.add(player);
        return true;
    }

    public void signUp(Player player) {
        players.add(player);
        System.out.println("Player Signed Up successfully!!!");
    }

}

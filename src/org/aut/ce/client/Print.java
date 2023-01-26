package org.aut.ce.client;

import org.aut.ce.common.Card;
import org.aut.ce.common.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Print implements Serializable {


    private static final String indent = "\t\t\t      ";



    public static void calibrate(Scanner finish)
    {
        clear();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(Color.getColorCodeString(Color.RESET) + indent + "\b\b\b\b\b\b\b" +
                "please use (cntrl, +) and (cntrl, -) to fit this line to your screen");

        System.out.println("<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>");
        finishEnter(finish);
    }

    public static void printMenu()
    {
        clear();
        System.out.println(Color.getColorCodeString(Color.RESET));

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(indent + "\t       " + " <••••••. UNO Game .••••••> ️");
        System.out.print("\n\n");
        System.out.println(indent + "\t      " + "            1. New game");
        System.out.print("\n");
        System.out.println(indent + "\t      " + "              2. exit");
        System.err.println(indent + "\t       " + " <••••••••••••••••••••••••> ");
        System.out.print("\n\n");
        System.out.print(  indent + "\t      " + "                0_0? ");
    }

    public static void getNumberOfThePlayers()
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(indent + "\b\b\b" +
                "Please enter the number of the players (1 < n < 5):  ");
    }

    public static void getPlayerName(int playerNum)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(indent + "\b\b\b\b\b\b\b\b\b\b\b" +
                "Please type the name of the player" + playerNum +" (if you want to make bot type bot):  ");
    }

    public static void getPlayerPass(String playerName)
    {
        clear();

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(indent + "\b" +
                "Hi " +  Color.getColorCodeString(Color.BLACK) + playerName +
                Color.getColorCodeString(Color.RESET) + " Please choose a password for yourself:  ");
    }

    public static void getPassToStartTurn(Player player)
    {
        clear();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print(Color.getColorCodeString(Color.RESET) + "\t\t  " +
                "Hey " + Color.getColorCodeString(Color.BLACK) +  player.getFirstName() +
                Color.getColorCodeString(Color.RESET) +
                " it's your turn. enter your pass to continue: ");
    }

    public static void printNumberOfPlayersCards(ArrayList<Player> players, int currentPlayerIndex)
    {
        System.out.println("\nNumber Of The Players Cards:\n");
        int cntr = 0;
        for (Player player: players)
        {
            System.out.print("\t " + player.getFirstName() + ":  " + player.getNumberOfPlayerCards());

            if (cntr == 0 && (currentPlayerIndex == (players.size()-1)))
                System.out.print("\t---> (next player)");

            if (cntr == currentPlayerIndex)
                System.out.print("\t---> (currrent player)");
            else if ((cntr-1) == currentPlayerIndex)
                System.out.print("\t---> (next player)");


            System.out.print("\n");


            cntr++;
        }
        System.out.print("\n\n");
    }

    public static void printPlayerCards(Player player)
    {
        for (int j = 0; j < player.getPlayerCards().size(); j += 9)
        {
            for (int i = 1; i <= 8; i++)
            {
                System.out.print("\t\b");
                for (int k = j; (k < j+9) && (k < player.getPlayerCards().size()); k++)
                {
                    System.out.print(player.getPlayerCards().get(k).toString() + "  ");

                    if (i == 8)
                        //      space = lenght of the previous line - current line lenght
                        for(int space =  player.getPlayerCards().get(k).toString().length() - player.getPlayerCards().get(k).toString().length();
                            space > 0; space--)
                            System.out.print(" ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    public static void getPlayerChosenColor()
    {
        System.out.println("You uesed a wild card. now choose a color ( " + Color.getColorCodeString(Color.BLACK) +
                Color.getColorCodeString(Color.RED) + " 1 " + Color.getColorCodeString(Color.RESET) +
                ", " + Color.getColorCodeString(Color.BLACK) +
                Color.getColorCodeString(Color.YELLOW) + " 2 " + Color.getColorCodeString(Color.RESET) +
                ", " + Color.getColorCodeString(Color.BLACK) +
                Color.getColorCodeString(Color.GREEN) + " 3 " + Color.getColorCodeString(Color.RESET) +
                ", " + Color.getColorCodeString(Color.BLACK) +
                Color.getColorCodeString(Color.BLUE) + " 4 " + Color.getColorCodeString(Color.RESET) +
                " ) :   ");
    }

    public static void printGameBoard(Card theCardOnTheBoard, Color colorOnTheBoard)
    {
        clear();


        for (int j = 1; j <= 7; j++)
        {
            System.out.print(indent + "\t\t\b" + theCardOnTheBoard.toString() + "    " + theCardOnTheBoard.toString());
            if (j == 2)
                System.out.print("  table color");
            else if (j > 2 && j < 6)
                System.out.print("    " + Color.getColorCodeString(colorOnTheBoard) + "      " +
                        Color.getColorCodeString(Color.RESET));
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
    }

    public static void getPlayerChoice(Player player)
    {
        System.out.println("\nhey " + Color.getColorCodeString(Color.BLACK) +
                player.getFirstName() + Color.getColorCodeString(Color.RESET) +
                " choose a Card (enter the code of your choosen card):  ");
    }


    public static void printScores(ArrayList<Player> players, Scanner finish)
    {
        clear();
        System.out.print(Color.getColorCodeString(Color.BLACK)  + "\n\n\n\n\n\n\n");


        System.out.println(indent + "\b\b\b\b\b\bPlayers  name |  Players  Score         Number Of Players Cards");
        System.out.println(indent + "\b\b\b\b\b\b–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");

        Player currPlayer;
        for (Player player : players) {
            currPlayer = player;
            System.out.printf("%s\b\b\b\b\b\b%13s :  %7d                      %8d\n", indent,
                    currPlayer.getFirstName(),
                    currPlayer.getScore(),
                    currPlayer.getNumberOfPlayerCards());
        }

        System.out.print("\n\n\n\n" + Color.getColorCodeString(Color.RESET));
        finishEnter(finish);
    }




    // this method wait until player push 'enter' bottom
    private static void finishEnter(Scanner inputsSource)
    {
        System.out.println(indent + "\t\t    " + "(press enter to continue)");
        inputsSource.nextLine();
    }

    public static void noChoiceError(Scanner finish)
    {
        System.out.println("\t\t\t" +
                Color.getColorCodeString(Color.YELLOW)+ Color.getColorCodeString(Color.RED) +
                "< ! YOU CAN'T CHOOSE ANY CARD. ONE CARD HAVE GIVEN TO YOU ! >" +
                Color.getColorCodeString(Color.RESET));

        finishEnter(finish);
    }


    // this method clear the terminal
    private static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void inValidInputError(Scanner finish)
    {
        System.out.println(indent + "\t         " +
                Color.getColorCodeString(Color.YELLOW)+ Color.getColorCodeString(Color.RED) +
                "< ! YOUR INPUT IS INVALID ! >" +
                Color.getColorCodeString(Color.RESET));
        finishEnter(finish);
    }
}

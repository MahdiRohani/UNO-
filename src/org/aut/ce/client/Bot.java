package org.aut.ce.client;

import org.aut.ce.common.*;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends Player {

    public Bot(int num)
    {
        super("Bot"+num, "Bot"+num, 0);
    }


    public Card playTurn(ArrayList<Player> players, ArrayList<Card> penaltyCards, int botIndex)
    {
        Card botChosenCard = null;
        for (int n = 0; n < super.getPlayerCards().size(); n++)
        {
            botChosenCard = super.getPlayerCards().get(n);
            if (GameManager.checkChoose(botChosenCard, this)){
                this.getPlayerCards().remove(botChosenCard);
                score -= botChosenCard.getCardScore();
                break;
            }

        }

        if (botChosenCard instanceof WildColorCard || botChosenCard instanceof WildDraw4Card)
        {
            Random rand = new Random();
            switch (rand.nextInt(4) + 1) {
                case 1 -> GameManager.applyChoose(botChosenCard, Color.RED);
                case 2 -> GameManager.applyChoose(botChosenCard, Color.YELLOW);
                case 3 -> GameManager.applyChoose(botChosenCard, Color.GREEN);
                case 4 -> GameManager.applyChoose(botChosenCard, Color.BLUE);
            }
        }
        else {
            assert botChosenCard != null;
            GameManager.applyChoose(botChosenCard, botChosenCard.getCardColor());
        }
        if (botChosenCard instanceof WildDraw4Card)
        {
            int index = (botIndex+1)%players.size();
            int n = penaltyCards.size();

            for (; n > 0; n--)
            {
                players.get(index).addCard(penaltyCards.get(0));;
                penaltyCards.remove(0);
            }
        }


        return botChosenCard;
    }


}


package org.aut.ce.client;

import org.aut.ce.server.Card;
import org.aut.ce.server.Color;
import org.aut.ce.server.Draw2Card;
import org.aut.ce.server.NumberCard;
import org.aut.ce.server.ReverseCard;
import org.aut.ce.server.SkipCard;
import org.aut.ce.server.WildColorCard;
import org.aut.ce.server.WildDraw4Card;

import java.util.ArrayList;

public class Repository {

    private static ArrayList<org.aut.ce.server.Card> gameCards = new ArrayList<>();



    public org.aut.ce.server.Card getGameCards(int i){
        return getGameCards(i);
    }

    public void removeGameCards(int i){
        gameCards.remove(i);
    }

    public void setGameCards(Card card){
        gameCards.add(card);
    }



    public static void makeCards(org.aut.ce.server.Color cardColor, int cardCode)
    {

        gameCards.add(new org.aut.ce.server.NumberCard(0, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(9, cardColor, ++cardCode));



        gameCards.add(new org.aut.ce.server.NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new org.aut.ce.server.NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));



        gameCards.add(new org.aut.ce.server.SkipCard(cardColor, ++cardCode));
        gameCards.add(new SkipCard(cardColor, ++cardCode));


        gameCards.add(new org.aut.ce.server.ReverseCard(cardColor, ++cardCode));
        gameCards.add(new ReverseCard(cardColor, ++cardCode));


        gameCards.add(new org.aut.ce.server.Draw2Card(cardColor, ++cardCode));
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
    }


    private static void makeGameCards()
    {
        int cardCode = 0;

        makeCards(org.aut.ce.server.Color.RED, cardCode);
        cardCode += 25;

        // make yellow cards
        makeCards(org.aut.ce.server.Color.YELLOW, cardCode);
        cardCode += 25;

        // make green cards
        makeCards(org.aut.ce.server.Color.GREEN, cardCode);
        cardCode += 25;

        // make blue cards
        makeCards(Color.BLUE, cardCode);
        cardCode += 25;


        // make wild cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildColorCard(++cardCode));

        // make wild draw cards
        for (int n = 0; n < 4; n++)
            gameCards.add(new WildDraw4Card(++cardCode));
    }
}


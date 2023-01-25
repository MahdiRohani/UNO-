package org.aut.ce.client;



import java.util.ArrayList;

public class Repository {

    private static ArrayList<Card> gameCards = new ArrayList<>();



    public Card getGameCards(int i){
        return getGameCards(i);
    }

    public void removeGameCards(int i){
        gameCards.remove(i);
    }

    public void setGameCards(Card card){
        gameCards.add(card);
    }



    public static void makeCards(Color cardColor, int cardCode)
    {

        gameCards.add(new NumberCard(0, cardColor, ++cardCode));
        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));



        gameCards.add(new NumberCard(1, cardColor, ++cardCode));
        gameCards.add(new NumberCard(2, cardColor, ++cardCode));
        gameCards.add(new NumberCard(3, cardColor, ++cardCode));
        gameCards.add(new NumberCard(4, cardColor, ++cardCode));
        gameCards.add(new NumberCard(5, cardColor, ++cardCode));
        gameCards.add(new NumberCard(6, cardColor, ++cardCode));
        gameCards.add(new NumberCard(7, cardColor, ++cardCode));
        gameCards.add(new NumberCard(8, cardColor, ++cardCode));
        gameCards.add(new NumberCard(9, cardColor, ++cardCode));



        gameCards.add(new SkipCard(cardColor, ++cardCode));
        gameCards.add(new SkipCard(cardColor, ++cardCode));


        gameCards.add(new ReverseCard(cardColor, ++cardCode));
        gameCards.add(new ReverseCard(cardColor, ++cardCode));


        gameCards.add(new Draw2Card(cardColor, ++cardCode));
        gameCards.add(new Draw2Card(cardColor, ++cardCode));
    }


    private static void makeGameCards()
    {
        int cardCode = 0;

        makeCards(Color.RED, cardCode);
        cardCode += 25;

        // make yellow cards
        makeCards(Color.YELLOW, cardCode);
        cardCode += 25;

        // make green cards
        makeCards(Color.GREEN, cardCode);
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


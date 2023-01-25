package org.aut.ce.server;

public class Card {
    private final Color cardColor;
    private final int cardScore;
    private final int cardCode;


    public Card(int cardScore, Color cardColor, int cardCode)
    {
        this.cardScore = cardScore;
        this.cardColor = cardColor;
        this.cardCode = cardCode;
    }


    public Color getCardColor(){
        return cardColor;
    }


    public int getCardScore(){
        return cardScore;
    }


    public int getCardCode(){
        return cardCode;
    }



    @Override
    public boolean equals(Object obj)
    {

        if (obj == this)
            return true;


        if (!(obj instanceof Card card))
            return false;

        return cardCode == card.cardCode;
    }


    public String toString(int lineNumber)
    {
        return switch (lineNumber) {

            case 1, 7 -> Color.getColorCodeString(Color.WHITE) + "•-------•" +
                    Color.getColorCodeString(Color.RESET);

            case 2, 3, 5, 6 -> Color.getColorCodeString(Color.WHITE) + "|   " +
                    Color.getColorCodeString(Color.GREEN) + "   " +
                    Color.getColorCodeString(Color.WHITE) + " |" +
                    Color.getColorCodeString(Color.RESET);

            case 4 -> Color.getColorCodeString(Color.WHITE) + "| " +
                    Color.getColorCodeString(Color.RED) + "U " +
                    Color.getColorCodeString(Color.YELLOW) + "N " +
                    Color.getColorCodeString(Color.BLUE) + "O " +
                    Color.getColorCodeString(Color.WHITE) + "|" +
                    Color.getColorCodeString(Color.RESET);

            default -> null;
        };
    }
}

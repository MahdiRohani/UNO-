package org.aut.ce.common;

public class WildDraw4Card extends Card{


    public WildDraw4Card(int cardCode)
    {
        super(50, Color.BLACK, cardCode);
    }

    @Override
    public String toString(int lineNumber) {

        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);
        String cardColorCode = Color.getColorCodeString(super.getCardColor());


        return switch (lineNumber) {
            case 1, 7 -> Color.getColorCodeString(Color.WHITE) + "•-------•" +
                    Color.getColorCodeString(Color.RESET);

            case 2 -> Color.getColorCodeString(Color.WHITE) + "|+4︎     |" +
                    Color.getColorCodeString(Color.RESET);

            case 3, 5 -> Color.getColorCodeString(Color.WHITE) + "|        |" +
                    Color.getColorCodeString(Color.RESET);

            case 4 -> Color.getColorCodeString(Color.WHITE) + "|" +
                    Color.getColorCodeString(Color.RED) + "W " +
                    Color.getColorCodeString(Color.YELLOW) + "i " +
                    Color.getColorCodeString(Color.GREEN) + "l " +
                    Color.getColorCodeString(Color.BLUE) + "d" +
                    Color.getColorCodeString(Color.WHITE) + "|" +
                    Color.getColorCodeString(Color.RESET);

            case 6 -> Color.getColorCodeString(Color.WHITE) + "|      +4|" +
                    Color.getColorCodeString(Color.RESET);

            case 8 -> Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                    Color.getColorCodeString(Color.RESET);

            default -> null;
        };
    }
}

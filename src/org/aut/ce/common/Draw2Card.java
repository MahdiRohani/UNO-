package org.aut.ce.common;

public class Draw2Card extends Card{


    public Draw2Card(Color cardColor, int cardCode)
    {
        super(20, cardColor, cardCode);
    }

    @Override
    public String toString(int lineNumber) {

        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);

        String cardColorCode = Color.getColorCodeString(super.getCardColor());

        return switch (lineNumber) {
            case 1, 7 -> cardColorCode + "•-------•" +
                    Color.getColorCodeString(Color.RESET);

            case 2 -> cardColorCode + "|+2     |" +
                    Color.getColorCodeString(Color.RESET);

            case 3, 5 -> cardColorCode + "|       |" +
                    Color.getColorCodeString(Color.RESET);

            case 4 -> cardColorCode + "| Draw2 |" +
                    Color.getColorCodeString(Color.RESET);

            case 6 -> cardColorCode + "|     +2|" +
                    Color.getColorCodeString(Color.RESET);

            case 8 -> Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                    Color.getColorCodeString(Color.RESET);
            default -> null;
        };

    }
}

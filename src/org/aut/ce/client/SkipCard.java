package org.aut.ce.client;

public class SkipCard extends Card{


    public SkipCard(Color cardColor, int cardCode)
    {
        super(20, cardColor, cardCode);
    }


    public String toString(int lineNumber)

    {
        String cardColorCode = Color.getColorCodeString(super.getCardColor());

        return switch (lineNumber) {
            case 1, 7 -> cardColorCode + "•-------•" +
                    Color.getColorCodeString(Color.RESET);

            case 2 -> cardColorCode + "|S      |" +
                    Color.getColorCodeString(Color.RESET);

            case 3, 5 -> cardColorCode + "|       |" +
                    Color.getColorCodeString(Color.RESET);

            case 4 -> cardColorCode + "|S k i p|" +
                    Color.getColorCodeString(Color.RESET);

            case 6 -> cardColorCode + "|      S|" +
                    Color.getColorCodeString(Color.RESET);

            case 8 -> Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                    Color.getColorCodeString(Color.RESET);

            default -> null;
        };

    }

}


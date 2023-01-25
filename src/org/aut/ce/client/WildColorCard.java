package org.aut.ce.client;

import org.aut.ce.server.Card;
import org.aut.ce.server.Color;

public class WildColorCard extends Card {


    public WildColorCard(int cardCode)
    {
        super(50, org.aut.ce.server.Color.BLACK, cardCode);
    }

    @Override
    public String toString(int lineNumber) {

        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);
        String cardColorCode = org.aut.ce.server.Color.getColorCodeString(super.getCardColor());

        return switch (lineNumber) {
            case 1, 7 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "•-------•" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 2 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "|W︎      |" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 3, 5 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "|       |" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 4 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "|" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RED) + "W " +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.YELLOW) + "i " +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.GREEN) + "l " +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.BLUE) + "d" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "|" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 6 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "|       W|" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 8 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.WHITE) + "code: " + super.getCardCode() +
                    org.aut.ce.server.Color.getColorCodeString(Color.RESET);

            default -> null;
        };

    }
}

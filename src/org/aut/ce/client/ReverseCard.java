package org.aut.ce.client;

import org.aut.ce.server.Card;
import org.aut.ce.server.Color;

public class ReverseCard extends Card {

    public ReverseCard(org.aut.ce.server.Color cardColor, int cardCode) {
        super(20, cardColor, cardCode);
    }

    @Override
    public String toString(int lineNumber) {

        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);

        String cardColorCode = org.aut.ce.server.Color.getColorCodeString(super.getCardColor());

        return switch (lineNumber) {
            case 1, 7 -> cardColorCode + "•-------•" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 2 -> cardColorCode + "|<->    |" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 3, 5 -> cardColorCode + "|       |" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 4 -> cardColorCode + "|Reverse|" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 6 -> cardColorCode + "|    <->|" +
                    org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RESET);

            case 8 -> org.aut.ce.server.Color.getColorCodeString(org.aut.ce.server.Color.RED) + "code: " + super.getCardCode() +
                    org.aut.ce.server.Color.getColorCodeString(Color.RESET);

            default -> null;
        };

    }
}


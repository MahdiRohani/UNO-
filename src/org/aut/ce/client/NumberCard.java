package org.aut.ce.client;

public class NumberCard extends Card {

    private int cardNumber;



    public NumberCard(int cardNumber, Color cardColor, int cardCode) {
        super(cardNumber, cardColor, cardCode);
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString(int lineNumber) {

        if (lineNumber < 0)
            return super.toString((-1)*lineNumber);
        String cardColorCode = Color.getColorCodeString(super.getCardColor());

        return switch (lineNumber) {
            case 1, 7 -> cardColorCode + "•-------•" +
                    Color.getColorCodeString(Color.RESET);

            case 2 -> cardColorCode + "|" + cardNumber + "      |" +
                    Color.getColorCodeString(Color.RESET);

            case 3, 4, 5 -> cardColorCode + "|       |" +
                    Color.getColorCodeString(Color.RESET);

            case 6 -> cardColorCode + "|      " + cardNumber + "|" +
                    Color.getColorCodeString(Color.RESET);

            case 8 -> Color.getColorCodeString(Color.WHITE) + "code: " + super.getCardCode() +
                    Color.getColorCodeString(Color.RESET);

            default -> null;
        };

    }

}

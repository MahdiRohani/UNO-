package org.aut.ce.client;

public enum Color {
    RED,
    YELLOW,
    GREEN,
    BLUE,
    BLACK,
    RESET,
    WHITE,


    BLACK_B,
    RED_B,
    YELLOW_B,
    GREEN_B,
    BLUE_B,
    WHITE_B;

    private String colorCodeString;
    static
    {
        BLACK.colorCodeString = "\033[0;30m";
        RED.colorCodeString = "\033[0;91m";
        YELLOW.colorCodeString = "\033[0;93m";
        GREEN.colorCodeString = "\033[0;92m";
        BLUE.colorCodeString = "\033[0;96m";
        WHITE.colorCodeString = "\033[0;97m";

        RESET.colorCodeString = "\033[92;40m";

        BLACK_B.colorCodeString = "\033[40m";
        RED_B.colorCodeString = "\033[101m";
        YELLOW_B.colorCodeString = "\033[103m";
        GREEN_B.colorCodeString = "\033[102m";
        BLUE_B.colorCodeString = "\033[106m";
        WHITE_B.colorCodeString = "\033[107m";

    }
}

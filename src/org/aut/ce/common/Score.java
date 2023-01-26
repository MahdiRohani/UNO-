package org.aut.ce.common;

import org.aut.ce.client.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable {
    private static final ArrayList<String> firstName = new ArrayList<>();
    private static final ArrayList<Integer> score = new ArrayList<>();
    private static final ArrayList<Integer> numberOfPlayer = new ArrayList<>();

    private static final String indent = "\t\t\t      ";

    public static void getScore(ArrayList<org.aut.ce.client.Player> player) {
        org.aut.ce.client.Player currPlayer;
        for (Player players : player) {
            currPlayer = players;
            firstName.add(currPlayer.getFirstName());
            score.add(currPlayer.getScore());
            numberOfPlayer.add(currPlayer.getNumberOfPlayerCards());
        }
    }

    public static void printScore(){
        System.out.println(indent + "\b\b\b\b\b\bPlayers  name |  Players  Score         Number Of Players Cards");
        System.out.println(indent + "\b\b\b\b\b\b–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");

        for (int i = 0; i< firstName.size(); i++){
            System.out.printf("%s\b\b\b\b\b\b%13s :  %7d                      %8d\n", indent,
                    firstName.get(i),
                    score.get(i),
                    numberOfPlayer.get(i));
        }
    }

    @Override
    public String toString()
    {
        return firstName.get(0) + score.get(0) + numberOfPlayer.get(0) + "\n" +
                firstName.get(1) + score.get(1) + numberOfPlayer.get(1) + "\n" +
                firstName.get(2) + score.get(2) + numberOfPlayer.get(2) + "\n" +
                firstName.get(3) + score.get(3) + numberOfPlayer.get(3) + "\n" ;
    }





}


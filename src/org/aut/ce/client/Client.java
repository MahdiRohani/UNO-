package org.aut.ce.client;



import org.aut.ce.common.Score;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Scanner inputs = new Scanner(System.in);


    public static void main(String[] args) {






        Print.calibrate(inputs);

            String holdInput; // hold the input to check that its valid or not
            int numberOfPlayers; // the number of the game players
            String newPlayerName, newPlayerPass; // get the new player details
            int age = 0;


            // while player choose exit option
            while (true) {
                // while player choose valid option
                while (true) {
                    // show the game menu tho the player and get his/her choice
                    Print.printMenu();
                    holdInput = inputs.nextLine();

                    // check the player input
                    if (holdInput.length() == 1 && (holdInput.charAt(0) == '1' || holdInput.charAt(0) == '2'))
                        break;
                    else
                        Print.inValidInputError(inputs);
                }


                switch (holdInput) {
                    case "1":
                        // while the player choose a valid int
                        while (true) {
                            // get the player choice
                            Print.getNumberOfThePlayers();
                            holdInput = inputs.nextLine();

                            // check the player input
                            if (holdInput.length() == 1 && holdInput.charAt(0) > '0' && holdInput.charAt(0) < '8')
                                break;
                            else
                                Print.inValidInputError(inputs);
                        }
                        numberOfPlayers = (int) holdInput.charAt(0) - (int) '0';

                        // get the players detials
                        for (int n = 0; n < numberOfPlayers; n++) {
                            // get the player name
                            Print.getPlayerName(n + 1);
                            newPlayerName = inputs.nextLine();
                            if (newPlayerName.toLowerCase().equals("bot")) {
                                // creat a bot
                                GameManager.addPlayer(new Bot(n));
                            } else {
                                // get the player password
                                Print.getPlayerPass(newPlayerName);
                                newPlayerPass = inputs.nextLine();


                                // creat new player
                                GameManager.addPlayer(new Player(newPlayerName, newPlayerPass, age));
                            }
                        }

                        // get the cards to the players
                        GameManager.preparationGameCards();
                        GameManager.distributeCards();

                        GameManager.runGame(inputs);


                        // reset the game
                        GameManager.reset();

                        break;

                    case "2":
                        return;
                }
            }

        }



}

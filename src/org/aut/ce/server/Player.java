package org.aut.ce.server;

import org.aut.ce.common.Card;

import java.util.ArrayList;

public class Player extends User {

    protected int score;
    private String playerPass;
    private ArrayList<Card> playerCards;



    public Player(String firstName,String playerPass,int age)
    {
        super(firstName, age);

        this.score = 0;
        this.playerPass = playerPass;
        playerCards = new ArrayList<>();
    }

    public void addCard(Card cardToAdd)
    {
        score += cardToAdd.getCardScore();
        playerCards.add(cardToAdd);
    }


    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }


    public int getNumberOfPlayerCards()
    {
        return playerCards.size();
    }


    public ArrayList<Card> getPlayerCards()
    {
        return playerCards;
    }


    public Card removeCard(int cardCodeToRemove) {
        Card cardToRemove = null;
        for (Card card : playerCards) {
            if (card.getCardCode() == cardCodeToRemove) {
                cardToRemove = card;
                break;
            }
        }

        assert cardToRemove != null;
        score -= cardToRemove.getCardScore();
        playerCards.remove(cardCodeToRemove);

        return cardToRemove;
    }



    public String getPlayerPass()
    {
        return playerPass;
    }
    public void setPlayerPass(String playerPass){
        this.playerPass = playerPass;
    }

    public boolean haveCard(int cardCode)
    {
        for (Card card: playerCards)
        {
            if (card.getCardCode() == cardCode)
                return true;
        }
        return false;
    }


}
package org.aut.ce.client;



public class AuthenticationService {

    private String userName;
    private String pass;


    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public static void checkPass(Player player, String pass){
        while (true)
        {
            if (player.getPlayerPass().equals(pass))
                break;

        }

    }




}

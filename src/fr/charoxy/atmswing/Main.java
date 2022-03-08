package fr.charoxy.atmswing;

public class Main {

    static SQLConnexion connexion = new SQLConnexion("localhost/Banque","maxence" , "root");
    public static void main(String[] args) {

        Fenetre fen = new Fenetre(connexion);

    }


}

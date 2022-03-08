package fr.charoxy.atmswing;

import org.mariadb.jdbc.Connection;


import javax.swing.text.StyledEditorKit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLConnexion {

    private Connection conn;
    public SQLConnexion(String URL,String user, String mdp) {

        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mariadb://" + URL, user ,mdp);
            System.out.println("* ATM AP > Connexion a la base de donnée ok");


        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public Connection getConnexion() {
        return conn;
    }

    public void setData(int accountNum, float solde){

        try {
            conn.createStatement().executeUpdate("UPDATE `Compte` SET `Solde`=\""+ solde +"\" WHERE NumCompte=" + accountNum);
            System.out.println("* ATM AP > Les valeur on bien etais modifier !");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Boolean checkLog(int AcountNum, String mdp){

        try {
            ResultSet set = conn.createStatement().executeQuery("SELECT * FROM Compte WHERE NumCompte=\"" + AcountNum  + "\" AND Mdp=\""+ mdp + "\"");
            if(set.next()){
                if(set.getString(1) != null){
                    System.out.println("* L'utilisateur a etais Authentifier");
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public float getMoney(int accountNumber){
        try {
            ResultSet set = conn.createStatement().executeQuery("SELECT * FROM Compte WHERE NumCompte=\"" + accountNumber  + "\"");
            if(set.next()){
                if(set.getString(1) != null){
                    return set.getFloat(4);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public String getNom(int accountNumber){
        try {
            ResultSet set = conn.createStatement().executeQuery("SELECT * FROM Compte WHERE NumCompte=\"" + accountNumber  + "\"");
            if(set.next()){
                if(set.getString(1) != null){
                    return set.getString(2);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
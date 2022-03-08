package fr.charoxy.atmswing;

import fr.charoxy.atmswing.panel.Login;

import javax.swing.*;

public class Fenetre extends JFrame {

    public Fenetre(SQLConnexion sql){
        Login log = new Login(sql , this);
        this.setContentPane(log);
        setSize(300,400);
        setTitle("ATM SWING");
        setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
    }



}

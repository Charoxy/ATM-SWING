package fr.charoxy.atmswing.panel;

import fr.charoxy.atmswing.SQLConnexion;

import javax.swing.*;

public class AtmPanel extends JPanel {

    JLabel lSolde,numCompte,nom;
    JButton depo,retier;
    JTextField Tdepo , Tretier;
    float solde;



    public AtmPanel(int numAccount , SQLConnexion sql , JFrame frame){
        this.setLayout(null);

        solde = sql.getMoney(numAccount);

        lSolde = new JLabel();
        lSolde.setText("Solde = " + solde);
        lSolde.setBounds(0,0,100,100);
        this.add(lSolde);


        depo = new JButton();
        depo.setBounds(25,250,100,25);
        depo.setText("Deposé");
        depo.addActionListener(e -> {
            solde = solde + Integer.parseInt(Tdepo.getText());
            sql.setData(numAccount , solde);
            lSolde.setText("Solde = " + solde + "");

        });
        this.add(depo);

        retier = new JButton();
        retier.setBounds(150,250,100,25);
        retier.setText("retiré");
        retier.addActionListener(e -> {
            solde = solde - Integer.parseInt(Tretier.getText());

            if(solde < 0){
                JOptionPane.showMessageDialog(frame , "Tu n'as pas assez d'argent");
                return;
            }

            sql.setData(numAccount , solde);
            lSolde.setText("Solde = " + solde + "");
        });
        this.add(retier);

        Tdepo = new JTextField();
        Tdepo.setBounds(25,200,100,25);
        this.add(Tdepo);

        Tretier = new JTextField();
        Tretier.setBounds(150,200,100,25);
        this.add(Tretier);

        nom = new JLabel();
        nom.setText(sql.getNom(numAccount));
        nom.setBounds(0,15,100,25);
        this.add(nom);

    }

}

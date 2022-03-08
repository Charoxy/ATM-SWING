package fr.charoxy.atmswing.panel;

import fr.charoxy.atmswing.SQLConnexion;

import javax.swing.*;

public class Login extends JPanel {


    JTextField mdp,nom;
    JButton valider;

    public Login(SQLConnexion sql , JFrame frame){

        this.setLayout(null);

        nom = new JTextField();
        nom.setBounds(100,100,100,25);
        this.add(nom);

        mdp = new JTextField();
        mdp.setBounds(100,200,100,25);
        this.add(mdp);

        valider = new JButton();
        valider.setText("Validé");
        valider.setBounds(100,250,100,25);
        valider.addActionListener(e -> {
            System.out.println("text");

            try{
                if(sql.checkLog(Integer.parseInt(nom.getText()), mdp.getText())){

                    frame.setContentPane(new AtmPanel(Integer.parseInt(nom.getText()), sql , frame));
                    frame.revalidate();
                    frame.repaint();
                }else{
                    JOptionPane.showMessageDialog(frame , "Mauvais Mots de passe / Numero de compte");
                }
            }catch (NumberFormatException er){
                JOptionPane.showMessageDialog(frame , "Que des nombres dans le premier champ peut etre utiliser");
            }


        });
        this.add(valider);




    }

}

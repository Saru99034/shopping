/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;

import java.awt.HeadlessException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author 33768
 */
public class ModifierArticle extends javax.swing.JFrame {

    private String mailAdress;
    private int mois;
    private int annee;
    private int jour;
    private int heure;
    private int minute;
    private int seconde;
    private String nom;
    private String prenom;

    /**
     * Creates new form ModifierArticle
     *
     */
    public ModifierArticle() {
        initComponents();
        dateHeure();
        // nomEmploye();
        //prenomEmploye();
        article();
    }

    public ModifierArticle(String adresseMail) {
        initComponents();
        this.mailAdress = adresseMail;
        
        textNom.setVisible(false);
        textPrenom.setVisible(false);
        dateHeure();
       
      //  nomEmploye();
      //  prenomEmploye();
        article();
    }

    public String getMailAdress() {
        return this.mailAdress;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    /*public int getJour() {
        return this.jour;
    }

    public int getMois() {
        return this.mois;
    }

    public int getAnnee() {
        return this.annee;
    }

    public int getHeure() {
        return this.heure;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSeconde() {
        return this.seconde;
    }*/

     Connection con;
     PreparedStatement pst;
     ResultSet rs;

    public void connexion() {
        try {
            //maconnexion= new Connexion("shopping","root","");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //nameDatabase="shopping";  //nom de la database sur wampserveur
            String urlDatabase = "jdbc:mysql://localhost:3306/shopping";

            //création d'une connexion JDBC à la base 
            con = DriverManager.getConnection(urlDatabase,"root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void article() {
   
       /* Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {*/
                    try {
                        connexion();
                        String sqlSelectMarque = "SELECT marque from article";
                        pst = con.prepareStatement(sqlSelectMarque);
                        rs = pst.executeQuery();

                        while(rs.next()) {
                            comboBoxMarque.addItem(rs.getString("marque"));

                        }
                        con.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                   /*  }
            }

        };
        tr.start();*/

    }
              
    
    
    
        

             // sous programme pour avoir la date actuelle et l'heure actuelle
    public void dateHeure() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Calendar calendrier = new GregorianCalendar();

                        annee = calendrier.get(Calendar.YEAR);
                        mois = calendrier.get(Calendar.MONTH);
                        jour = calendrier.get(Calendar.DAY_OF_MONTH);

                        heure = calendrier.get(Calendar.HOUR_OF_DAY);
                        minute = calendrier.get(Calendar.MINUTE);
                        seconde = calendrier.get(Calendar.SECOND);

                        mois = mois + 1;
                        textDate.setText(jour + "/" + mois + "/" + annee);
                        textHeure.setText(heure + ":" + minute + ":" + seconde);
                        sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        tr.start();

    }

    /*      public void nomEmploye() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        connexion();
                        String requeteSelectNom = "SELECT employe_nom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectNom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            //nom=rs.getString("employe_nom");
                            //System.out.println("Nom Employé: "+nom);
                            textNom.setText(rs.getString("employe_nom").toUpperCase());
                            textNom.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        tr.start();

    }

    public void prenomEmploye() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        connexion();
                        String requeteSelectPrenom = "SELECT employe_prenom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectPrenom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            //prenom=rs.getString("employe_prenom");
                            // System.out.println("Prenom Employé: "+prenom);
                            textPrenom.setText(rs.getString("employe_prenom"));
                            textPrenom.setVisible(true);
                            buttonDeco.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        tr.start();

    }*/

            /**
             * This method is called from within the constructor to initialize
             * the form. WARNING: Do NOT modify this code. The content of this
             * method is always regenerated by the Form Editor.
             */
            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textDate = new javax.swing.JLabel();
        textHeure = new javax.swing.JLabel();
        textNom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonDeco = new javax.swing.JButton();
        buttonRetour = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboBoxMarque = new javax.swing.JComboBox<>();
        buttonValider1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textPrixUnit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textPrixPack = new javax.swing.JTextField();
        textQuantite = new javax.swing.JLabel();
        textQuantitePack = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textDescription = new javax.swing.JTextField();
        buttonModifier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textDate.setText("DATE");

        textHeure.setText("HEURE");

        textNom.setText("Nom");

        textPrenom.setText("Prenom");

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel1.setText("Modifier l'article");

        buttonDeco.setBackground(new java.awt.Color(0, 0, 0));
        buttonDeco.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        buttonDeco.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeco.setText("SE DECONNECTER");
        buttonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDecoActionPerformed(evt);
            }
        });

        buttonRetour.setBackground(new java.awt.Color(0, 0, 0));
        buttonRetour.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        buttonRetour.setForeground(new java.awt.Color(255, 255, 255));
        buttonRetour.setText("Retour");
        buttonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel2.setText("Choisissez la marque");

        comboBoxMarque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez l'article" }));

        buttonValider1.setBackground(new java.awt.Color(0, 0, 0));
        buttonValider1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        buttonValider1.setForeground(new java.awt.Color(255, 255, 255));
        buttonValider1.setText("Valider");
        buttonValider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValider1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel3.setText("Prix unitaire");

        textPrixUnit.setText("0");

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel4.setText("Prix pack");

        textPrixPack.setText("0");

        textQuantite.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        textQuantite.setText("Quantité pack");

        textQuantitePack.setText("0");
        textQuantitePack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textQuantitePackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel5.setText("Stock");

        textStock.setText("0");

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jLabel6.setText("Description");

        textDescription.setText("0");

        buttonModifier.setBackground(new java.awt.Color(0, 0, 0));
        buttonModifier.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        buttonModifier.setForeground(new java.awt.Color(255, 255, 255));
        buttonModifier.setText("Modifier");
        buttonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textHeure))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textNom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textPrenom)))
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(buttonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboBoxMarque, 0, 0, Short.MAX_VALUE)
                                        .addComponent(buttonValider1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textPrixPack, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textQuantite)
                                            .addComponent(textQuantitePack, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(65, 65, 65)
                                        .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrixUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(buttonRetour)
                .addGap(231, 231, 231)
                .addComponent(buttonModifier)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDate)
                            .addComponent(textHeure))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNom)
                            .addComponent(textPrenom)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDeco))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxMarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonValider1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textPrixUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrixPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(textQuantite))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textQuantitePack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonModifier)
                            .addComponent(buttonRetour))
                        .addGap(97, 97, 97))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDecoActionPerformed
        // TODO add your handling code here:
        ModifierArticle.super.dispose();
        connexion();

        Home homepage = new Home();
        homepage.setVisible(true);
    }//GEN-LAST:event_buttonDecoActionPerformed

    private void buttonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourActionPerformed
        // TODO add your handling code here:
        ModifierArticle.super.dispose();
        connexion();

        //PageEmpConnecte retourPageEmp = new PageEmpConnecte(getMailAdress());
        PageEmpConnecte retourPageEmp = new PageEmpConnecte(getMailAdress());
        retourPageEmp.setVisible(true);
    }//GEN-LAST:event_buttonRetourActionPerformed

    private void textQuantitePackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textQuantitePackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textQuantitePackActionPerformed

    private void buttonValider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValider1ActionPerformed
        // TODO add your handling code here:

        try {
            connexion();
            String sqlSelectMarque = "SELECT prix_unitaire,prix_pack,Quantite_pack,stock,description FROM article WHERE marque=?";
            pst = con.prepareStatement(sqlSelectMarque);
            pst.setString(1, comboBoxMarque.getSelectedItem().toString());
            rs = pst.executeQuery();

            while(rs.next()) {
                textPrixUnit.setText(rs.getString("prix_unitaire"));
                textPrixPack.setText(rs.getString("prix_pack"));
                textQuantitePack.setText(rs.getString("Quantite_pack"));
                textStock.setText(rs.getString("stock"));
                textDescription.setText(rs.getString("description"));
            }
             con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonValider1ActionPerformed

    private void buttonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifierActionPerformed
        // TODO add your handling code here:
       
        try {
            connexion();
            pst = con.prepareStatement("UPDATE article SET prix_unitaire=?,prix_pack=?,Quantite_pack=?,stock=?,description=? WHERE marque=?");
            pst.setString(1, textPrixUnit.getText());
            pst.setString(2, textPrixPack.getText());
            pst.setString(3, textQuantitePack.getText());
            pst.setString(4, textStock.getText());
            pst.setString(5, textDescription.getText());
            pst.setString(6, comboBoxMarque.getSelectedItem().toString());
            pst.executeUpdate();
           // con.close();
            String messageTempo1 = "L'article " + comboBoxMarque.getSelectedItem().toString() + " a bien été modifié.";
            JOptionPane.showMessageDialog(null, messageTempo1);

        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "La modification a échoué: recommencez...");
        }      
        
    }//GEN-LAST:event_buttonModifierActionPerformed

            /* public void tableArticle()
    {
        String[] article={"MARQUE","PRIX_UNITAIRE","PRIX_PACK","QUANTITE_PACK","STOCK","DESCRIPTION"};
        
        String[] info=new String[7];
        
        //DefaultTableModel model=new DefaultTableModel new(null,article);
        String sqlSelectArticle="SELECT * FROM article";
        
        try{
            connexionClient();
            Statement st=con.createStatement();
            rs=st.executeQuery(sqlSelectArticle);
            
            while(rs.next())
            {
                info[0]="marque";
                info[1]="prix_unitaire";
                info[2]="prix_pack";
                info[3]="quantite_pack";
                info[4]="stock";
                info[5]="description";
                
            }
            con.close();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
            /**
             * @param args the command line arguments
             */
            public void main(String args[]) {
                /* Set the Nimbus look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(ModifierArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(ModifierArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(ModifierArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(ModifierArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ModifierArticle(getMailAdress()).setVisible(true);
                    }
                });
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeco;
    private javax.swing.JButton buttonModifier;
    private javax.swing.JButton buttonRetour;
    private javax.swing.JButton buttonValider1;
    private javax.swing.JComboBox<String> comboBoxMarque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel textDate;
    private javax.swing.JTextField textDescription;
    private javax.swing.JLabel textHeure;
    private javax.swing.JLabel textNom;
    private javax.swing.JLabel textPrenom;
    private javax.swing.JTextField textPrixPack;
    private javax.swing.JTextField textPrixUnit;
    private javax.swing.JLabel textQuantite;
    private javax.swing.JTextField textQuantitePack;
    private javax.swing.JTextField textStock;
    // End of variables declaration//GEN-END:variables


 }



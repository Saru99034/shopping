/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 33768
 */
public class PageEmpConnecte extends javax.swing.JFrame {

    /**
     * Creates new form PageEmpConnecte
     */
    public PageEmpConnecte() {
        initComponents();
        dateHeure();
       // PageConnexionEmploye pageCoEmp=new PageConnexionEmploye();
        textBienvenue.setVisible(true);
        textNom.setVisible(false);
        textPrenom.setVisible(false);
        buttonDeco.setVisible(true);
    }

    public PageEmpConnecte(String adresseMail) {
        initComponents();
        dateHeure();
        this.mailAdress = adresseMail;
        
        textBienvenue.setVisible(true);
        textNom.setVisible(false);
        //textNom.setText(this.mailAdress);
        
        textPrenom.setVisible(false);
        buttonDeco.setVisible(true);
        
        nomEmploye();
        prenomEmploye();

    }

    //accesseurs
    public String getMailAdress() {
        return this.mailAdress;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getAnnee() {
        return this.annee;
    }

    public int getMois() {
        return this.mois;
    }

    public int getJour() {
        return this.jour;
    }

    public int getHeure() {
        return this.heure;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSeconde() {
        return this.seconde;
    }

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
            con = DriverManager.getConnection(urlDatabase, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // sous programme pour avoir la date actuelle et l'heure actuelle
    public final void dateHeure() {
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

    public final void nomEmploye() {
      /*  Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {*/
                    try {
                        
                        connexion();
                        //PageConnexionEmploye pageCoEmp=new PageConnexionEmploye();
                        
                        String requeteSelectNom = "SELECT employe_nom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectNom);
                        pst.setString(1, getMailAdress());
                        System.out.println("Mail : "+getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            //nom=rs.getString("employe_nom");
                            //System.out.println("Nom Employé: "+nom);
                            textNom.setText(rs.getString("employe_nom").toUpperCase());
                            textBienvenue.setVisible(true);
                            textNom.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                        /*pst.close();
                        rs.close();*/
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
               /* }
            }

        };
        tr.start();*/

    }

    public final void prenomEmploye() {
        /*Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {*/
                    try {
                        connexion();
                        
                        String requeteSelectPrenom = "SELECT employe_prenom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectPrenom);
                        pst.setString(1, getMailAdress());
                        System.out.println("Mail : "+getMailAdress());
                        rs = pst.executeQuery();

                        while(rs.next()) {
                            //prenom=rs.getString("employe_prenom");
                            // System.out.println("Prenom Employé: "+prenom);
                            textPrenom.setText(rs.getString("employe_prenom"));
                            textPrenom.setVisible(true);
                            buttonDeco.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                        /*pst.close();
                        rs.close();*/
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
               /* }
            }

        };
        tr.start();*/

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        textHeure = new javax.swing.JLabel();
        textBienvenue = new javax.swing.JLabel();
        textNom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JLabel();
        buttonDeco = new javax.swing.JButton();
        panelBoutons = new javax.swing.JPanel();
        deleteArticle = new javax.swing.JButton();
        addArticle = new javax.swing.JButton();
        showOrders = new javax.swing.JButton();
        editArticle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1425, 825));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion du shopping");

        textDate.setText("DATE");

        textHeure.setText("HEURE");

        textBienvenue.setText("Bienvenue");

        textNom.setText("Nom");

        textPrenom.setText("Prenom");

        buttonDeco.setText("SE DECONNECTER");
        buttonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDecoActionPerformed(evt);
            }
        });

        panelBoutons.setBackground(new java.awt.Color(0, 255, 255));

        deleteArticle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteArticle.setText("Supprimer un article");
        deleteArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteArticleActionPerformed(evt);
            }
        });

        addArticle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addArticle.setText("Ajouter un article");
        addArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addArticleActionPerformed(evt);
            }
        });

        showOrders.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        showOrders.setText("Visualiser les commandes");
        showOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOrdersActionPerformed(evt);
            }
        });

        editArticle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editArticle.setText("Modifier un article");
        editArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoutonsLayout = new javax.swing.GroupLayout(panelBoutons);
        panelBoutons.setLayout(panelBoutonsLayout);
        panelBoutonsLayout.setHorizontalGroup(
            panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonsLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addArticle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showOrders)
                    .addComponent(deleteArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        panelBoutonsLayout.setVerticalGroup(
            panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textHeure))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textBienvenue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPrenom)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244)
                .addComponent(buttonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(panelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(buttonDeco)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDate)
                            .addComponent(textHeure))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textBienvenue)
                            .addComponent(textNom)
                            .addComponent(textPrenom))))
                .addGap(107, 107, 107)
                .addComponent(panelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
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
        PageEmpConnecte.super.dispose();
        connexion();

        Home homepage = new Home();
        homepage.setVisible(true);
    }//GEN-LAST:event_buttonDecoActionPerformed


    private void deleteArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteArticleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteArticleActionPerformed

    private void editArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editArticleActionPerformed
        // TODO add your handling code here:
        PageEmpConnecte.super.dispose();
        connexion();

       // ModifierArticle editProduct = new ModifierArticle(getMailAdress(),getNom(),getPrenom());
       ModifierArticle editProduct = new ModifierArticle(getMailAdress());
       editProduct.setVisible(true);
    }//GEN-LAST:event_editArticleActionPerformed

    private void addArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArticleActionPerformed
        // TODO add your handling code here:
        PageEmpConnecte.super.dispose();
        connexion();
        
       AjoutArticle addProduct = new AjoutArticle(getMailAdress());
       addProduct.setVisible(true);
    }//GEN-LAST:event_addArticleActionPerformed

    private void showOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showOrdersActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {  //////////////////PAS DE STATIC////////////////////////
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
            java.util.logging.Logger.getLogger(PageEmpConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageEmpConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageEmpConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageEmpConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageEmpConnecte(getMailAdress()).setVisible(true);///!!!!!!!!!!!!
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addArticle;
    private javax.swing.JButton buttonDeco;
    private javax.swing.JButton deleteArticle;
    private javax.swing.JButton editArticle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelBoutons;
    private javax.swing.JButton showOrders;
    private javax.swing.JLabel textBienvenue;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textHeure;
    private javax.swing.JLabel textNom;
    private javax.swing.JLabel textPrenom;
    // End of variables declaration//GEN-END:variables
    private String mailAdress;
    private int mois;
    private int annee;
    private int jour;
    private int heure;
    private int minute;
    private int seconde;
    private String nom;
    private String prenom;

}

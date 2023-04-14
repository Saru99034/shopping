/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;

import Connexion.*;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class PageCreationCompteEmploye extends javax.swing.JFrame {

    /**
     * Creates new form PageCreationCompteEmploye
     */
    public PageCreationCompteEmploye() {
        initComponents();
    }

     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * @param args the command line arguments
     */
       public void connexionEmploye()
    {
        try{
            //maconnexion= new Connexion("shopping","root","");
          Class.forName("com.mysql.cj.jdbc.Driver");
        
        //nameDatabase="shopping";  //nom de la database sur wampserveur
        String urlDatabase="jdbc:mysql://localhost:3306/shopping";
        
        //création d'une connexion JDBC à la base 
          con=DriverManager.getConnection(urlDatabase,"root","");
        }catch(Exception e)
        {
               e.printStackTrace();
        }
    } 
       
       @SuppressWarnings("unchecked")
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textNomEmploye = new javax.swing.JTextField();
        textPrenomEmploye = new javax.swing.JTextField();
        textTelEmploye = new javax.swing.JTextField();
        textMailEmploye = new javax.swing.JTextField();
        textNumVoieEmploye = new javax.swing.JTextField();
        textAdresseEmploye = new javax.swing.JTextField();
        textVilleEmploye = new javax.swing.JTextField();
        textPaysEmploye = new javax.swing.JTextField();
        textMdpEmploye = new javax.swing.JTextField();
        comboboxSexeEmploye = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1290, 860));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1290, 600));

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel1.setText("Nom:");

        jLabel2.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel2.setText("Prenom:");

        jLabel3.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel3.setText("Sexe:");

        jLabel4.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel4.setText("Téléphone:");

        jLabel5.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel5.setText("Adresse mail:");

        jLabel6.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel6.setText("Numéro de voie:");

        jLabel7.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel7.setText("Adresse:");

        jLabel8.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel8.setText("Ville:");

        jLabel9.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel9.setText("Pays:");

        jLabel10.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel10.setText("Mot de passe:");

        textNomEmploye.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        textNomEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomEmployeActionPerformed(evt);
            }
        });
        textNomEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNomEmployeKeyPressed(evt);
            }
        });

        textPrenomEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrenomEmployeActionPerformed(evt);
            }
        });
        textPrenomEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPrenomEmployeKeyPressed(evt);
            }
        });

        textTelEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTelEmployeKeyPressed(evt);
            }
        });

        textMailEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMailEmployeKeyPressed(evt);
            }
        });

        textNumVoieEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNumVoieEmployeKeyPressed(evt);
            }
        });

        textAdresseEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAdresseEmployeKeyPressed(evt);
            }
        });

        textVilleEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textVilleEmployeKeyPressed(evt);
            }
        });

        textPaysEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPaysEmployeKeyPressed(evt);
            }
        });

        textMdpEmploye.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMdpEmployeKeyPressed(evt);
            }
        });

        comboboxSexeEmploye.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homme", "Femme", "Autre", " " }));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Creer mon compte");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel11.setText("CREATION DE MON COMPTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textPrenomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboboxSexeEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTelEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMailEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNumVoieEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(163, 163, 163)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(textMdpEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textPaysEmploye, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAdresseEmploye, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textVilleEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel11)))
                .addContainerGap(407, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textAdresseEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textPrenomEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textVilleEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboboxSexeEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(textPaysEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTelEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(textMdpEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textMailEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNumVoieEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(466, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNomEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomEmployeActionPerformed

    }//GEN-LAST:event_textNomEmployeActionPerformed

    private void textPrenomEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrenomEmployeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrenomEmployeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try{
        connexionEmploye();
        pst=con.prepareStatement("INSERT INTO employe(id_employe,employe_nom,employe_prenom,employe_sexe,employe_tel,employe_mail,employe_num_voie,employe_adresse,employe_ville,employe_pays,employe_mdp) VALUES(NULL,?,?,?,?,?,?,?,?,?,?)");  //requête de création compte employé
        pst.setString(1,textNomEmploye.getText().toUpperCase());
        pst.setString(2,textPrenomEmploye.getText().toUpperCase());
        pst.setString(3,comboboxSexeEmploye.getSelectedItem().toString().toUpperCase());
        pst.setString(4,textTelEmploye.getText());
        pst.setString(5,textMailEmploye.getText());
        pst.setString(6,textNumVoieEmploye.getText());
        pst.setString(7,textAdresseEmploye.getText().toUpperCase());
        pst.setString(8,textVilleEmploye.getText().toUpperCase());
        pst.setString(9,textPaysEmploye.getText().toUpperCase());
        pst.setString(10,textMdpEmploye.getText());
        int row=pst.executeUpdate();
        
        int numero_de_tel_employe=Integer.parseInt(String.valueOf(textTelEmploye.getText()));
        int num_voie_employe=Integer.parseInt(String.valueOf(textNumVoieEmploye.getText()));
        myEmploye=new Employe(textNomEmploye.getText().toUpperCase(),textPrenomEmploye.getText().toUpperCase(),numero_de_tel_employe,textMailEmploye.getText(),num_voie_employe,textAdresseEmploye.getText().toUpperCase(),textVilleEmploye.getText().toUpperCase(),textPaysEmploye.getText().toUpperCase(),textMdpEmploye.getText().toUpperCase());
        myEmploye.toString();
        JOptionPane.showMessageDialog(null,"Votre compte a été créé avec succès");

        
       }catch(SQLException e)
       {
           e.printStackTrace();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    //si je clique sur creer mon compte
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void textNomEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomEmployeKeyPressed
       String nom=textNomEmploye.getText();
        
        int tailleNom=nom.length();
        
        char verifNom=evt.getKeyChar();
        
            if(tailleNom<30){
                
               if((verifNom>='0') && (verifNom<='9'))
                {
                textNomEmploye.setEditable(false);
                }else
               {
                   textNomEmploye.setEditable(true);
               }
               
            }else
            {     
        
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textNomEmploye.setEditable(true);
           }else
           {
               textNomEmploye.setEditable(false);
           }
        }     
    }//GEN-LAST:event_textNomEmployeKeyPressed

    private void textPrenomEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrenomEmployeKeyPressed
    String prenom=textPrenomEmploye.getText();
        
        int taillePrenom=prenom.length();
        
            if(taillePrenom<30){
                textPrenomEmploye.setEditable(true);
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textPrenomEmploye.setEditable(true);
           }else
           {
               textPrenomEmploye.setEditable(false);
           }
            } 
    }//GEN-LAST:event_textPrenomEmployeKeyPressed

    private void textTelEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelEmployeKeyPressed

  String numTel=textTelEmploye.getText();
        
        int tailleNumTel=numTel.length();
        
        char verifNum=evt.getKeyChar();
        
        if((verifNum>='0') && (verifNum<='9'))
        {
            if(tailleNumTel<10){
                textTelEmploye.setEditable(true);
            }else
            {
                textTelEmploye.setEditable(false);
            }
        }else
        {
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textTelEmploye.setEditable(true);
           }else
           {
               textTelEmploye.setEditable(false);
           }
        }  
    }//GEN-LAST:event_textTelEmployeKeyPressed

    private void textMailEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMailEmployeKeyPressed
 String numTel=textTelEmploye.getText();
        
        int tailleNumTel=numTel.length();
        
        char verifNum=evt.getKeyChar();
        
        if((verifNum>='0') && (verifNum<='9'))
        {
            if(tailleNumTel<10){
                textTelEmploye.setEditable(true);
            }else
            {
                textTelEmploye.setEditable(false);
            }
        }else
        {
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textTelEmploye.setEditable(true);
           }else
           {
               textTelEmploye.setEditable(false);
           }
        }  
    }//GEN-LAST:event_textMailEmployeKeyPressed

    private void textNumVoieEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumVoieEmployeKeyPressed
      String numVoie=textNumVoieEmploye.getText();
       
        int tailleNumVoie=numVoie.length();
        
        char verifNumVoie=evt.getKeyChar();
        
        if((verifNumVoie>='0') && (verifNumVoie<='9'))
        {
            if(tailleNumVoie<4){
                textNumVoieEmploye.setEditable(true);
            }else
            {
                textNumVoieEmploye.setEditable(false);
            }
        }else
        {
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textNumVoieEmploye.setEditable(true);
           }else
           {
               textNumVoieEmploye.setEditable(false);
           }
        }    
    }//GEN-LAST:event_textNumVoieEmployeKeyPressed

       
    private void textAdresseEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAdresseEmployeKeyPressed
      String adresse=textAdresseEmploye.getText();
        
        int tailleAdresse=adresse.length();
        
        char verifAdresse=evt.getKeyChar();
        
            if(tailleAdresse<50){
                
               if((verifAdresse>='0') && (verifAdresse<='9'))
                {
                textAdresseEmploye.setEditable(false);
                }else
               {
                   textAdresseEmploye.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textAdresseEmploye.setEditable(true);
           }else
           {
               textAdresseEmploye.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textAdresseEmployeKeyPressed

    private void textVilleEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textVilleEmployeKeyPressed
      String ville=textVilleEmploye.getText();
        
        int tailleVille=ville.length();
        
        char verifVille=evt.getKeyChar();
        
            if(tailleVille<30){
                
               if((verifVille>='0') && (verifVille<='9'))
                {
                textVilleEmploye.setEditable(false);
                }else
               {
                   textVilleEmploye.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textVilleEmploye.setEditable(true);
           }else
           {
               textVilleEmploye.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textVilleEmployeKeyPressed

    private void textPaysEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPaysEmployeKeyPressed
      String pays=textPaysEmploye.getText();
        
        int taillePays=pays.length();
        
        char verifPays=evt.getKeyChar();
        
            if(taillePays<30){
                
               if((verifPays>='0') && (verifPays<='9'))
                {
                textPaysEmploye.setEditable(false);
                }else
               {
                   textPaysEmploye.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textPaysEmploye.setEditable(true);
           }else
           {
               textPaysEmploye.setEditable(false);
           }
            }       
    }//GEN-LAST:event_textPaysEmployeKeyPressed

    private void textMdpEmployeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMdpEmployeKeyPressed
   String mdp=textMdpEmploye.getText();
        
        int tailleMdp=mdp.length();
        
            if(tailleMdp<12){
                textMdpEmploye.setEditable(true);
            }else
            {
                 if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textMdpEmploye.setEditable(true);
           }else
           {
               textMdpEmploye.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textMdpEmployeKeyPressed
   
       
       
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(PageCreationCompteEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageCreationCompteEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageCreationCompteEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageCreationCompteEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageCreationCompteEmploye().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxSexeEmploye;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textAdresseEmploye;
    private javax.swing.JTextField textMailEmploye;
    private javax.swing.JTextField textMdpEmploye;
    private javax.swing.JTextField textNomEmploye;
    private javax.swing.JTextField textNumVoieEmploye;
    private javax.swing.JTextField textPaysEmploye;
    private javax.swing.JTextField textPrenomEmploye;
    private javax.swing.JTextField textTelEmploye;
    private javax.swing.JTextField textVilleEmploye;
    // End of variables declaration//GEN-END:variables

  private Employe myEmploye;
}

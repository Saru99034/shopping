/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;

import java.sql.*;
import Connexion.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 33768
 */
public class Fenetre extends javax.swing.JFrame {

    /**
     * Creates new form Fenetre
     */
    public Fenetre() {
        initComponents();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
     public void connexion()
    {
        try{
            //maconnexion= new Connexion("shopping","root","");
          Class.forName("com.mysql.cj.jdbc.Driver");
        
        //nameDatabase="shopping";  //nom de la database sur wampserveur
        String urlDatabase="jdbc:mysql://localhost:3306/shopping";
        
        //création d'une connexion JDBC à la base 
          con=DriverManager.getConnection(urlDatabase,"root","root");
        }catch(Exception e)
        {
               e.printStackTrace();
        }
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
        textNomClient = new javax.swing.JTextField();
        textPrenomClient = new javax.swing.JTextField();
        textTelClient = new javax.swing.JTextField();
        textMailClient = new javax.swing.JTextField();
        textNumVoieClient = new javax.swing.JTextField();
        textAdresseClient = new javax.swing.JTextField();
        textVilleClient = new javax.swing.JTextField();
        textPaysClient = new javax.swing.JTextField();
        textMdpClient = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textNomClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomClientActionPerformed(evt);
            }
        });
        textNomClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNomClientKeyPressed(evt);
            }
        });

        textPrenomClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrenomClientActionPerformed(evt);
            }
        });
        textPrenomClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPrenomClientKeyPressed(evt);
            }
        });

        textTelClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelClientActionPerformed(evt);
            }
        });
        textTelClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTelClientKeyPressed(evt);
            }
        });

        textMailClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMailClientActionPerformed(evt);
            }
        });
        textMailClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMailClientKeyPressed(evt);
            }
        });

        textNumVoieClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumVoieClientActionPerformed(evt);
            }
        });
        textNumVoieClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNumVoieClientKeyPressed(evt);
            }
        });

        textAdresseClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAdresseClientActionPerformed(evt);
            }
        });
        textAdresseClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAdresseClientKeyPressed(evt);
            }
        });

        textVilleClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textVilleClientActionPerformed(evt);
            }
        });
        textVilleClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textVilleClientKeyPressed(evt);
            }
        });

        textPaysClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPaysClientActionPerformed(evt);
            }
        });
        textPaysClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPaysClientKeyPressed(evt);
            }
        });

        textMdpClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMdpClientActionPerformed(evt);
            }
        });
        textMdpClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMdpClientKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CREER MON COMPTE");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel1.setText("Nom:");

        jLabel2.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel2.setText("Votre prénom :");

        jLabel3.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel3.setText("Telephone:");

        jLabel4.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel4.setText("Votre mail :");

        jLabel5.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel5.setText("Votre numéro de voie :");

        jLabel6.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel6.setText("Adresse : ");

        jLabel7.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel7.setText("Ville : ");

        jLabel8.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel8.setText("Pays :");

        jLabel9.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel9.setText("Mot de passe :");

        jLabel10.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel10.setText("CREATION DE MON COMPTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(375, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textVilleClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textPaysClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textMdpClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(textMailClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPrenomClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textNomClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textTelClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textAdresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textNumVoieClient, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(489, 489, 489))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textPrenomClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textTelClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textMailClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textNumVoieClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textAdresseClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textVilleClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textPaysClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textMdpClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNomClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomClientActionPerformed

    private void textPrenomClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrenomClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrenomClientActionPerformed

    private void textTelClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelClientActionPerformed

    private void textMailClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMailClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMailClientActionPerformed

    private void textNumVoieClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumVoieClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumVoieClientActionPerformed

    private void textAdresseClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAdresseClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAdresseClientActionPerformed

    private void textVilleClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textVilleClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textVilleClientActionPerformed

    private void textPaysClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPaysClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPaysClientActionPerformed

    private void textMdpClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMdpClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMdpClientActionPerformed

    //enregistrer dans la database
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
          String dataNomClient=textNomClient.getText().toUpperCase();  
          String dataPrenomClient=textPrenomClient.getText().toUpperCase(); 
          String dataTelClient=textTelClient.getText(); 
          String dataMailClient=textMailClient.getText(); 
          String dataNumVoieClient=textNumVoieClient.getText();
          String dataAdresseClient=textAdresseClient.getText().toUpperCase(); 
          String dataVilleClient=textVilleClient.getText().toUpperCase();
          String dataPaysClient=textPaysClient.getText().toUpperCase(); 
          String dataMdpClient=textMdpClient.getText(); 
          
          
          //maconnexion= new Connexion("shopping","root","");
          Class.forName("com.mysql.cj.jdbc.Driver");
        
        //nameDatabase="shopping";  //nom de la database sur wampserveur
        String urlDatabase="jdbc:mysql://localhost:3306/shopping";
        
        //création d'une connexion JDBC à la base 
          con=DriverManager.getConnection(urlDatabase,"root","");
      
          
          String requeteInsertionClient="INSERT INTO client(id_client,client_nom,client_prenom,client_tel,client_mail,client_num_voie,client_adresse,client_ville,client_pays,client_mdp) VALUES(NULL,?,?,?,?,?,?,?,?,?)";
          
          pst=con.prepareStatement(requeteInsertionClient);
          pst.setString(1,dataNomClient);
          pst.setString(2,dataPrenomClient);
          pst.setString(3,dataTelClient);
          pst.setString(4,dataMailClient);
          pst.setString(5,dataNumVoieClient);
          pst.setString(6,dataAdresseClient);
          pst.setString(7,dataVilleClient);
          pst.setString(8,dataPaysClient);
          pst.setString(9,dataMdpClient);
          int row=pst.executeUpdate();
          
          
          //conversion des infos de type String en type int
          int numero_de_tel_client=Integer.parseInt(String.valueOf(dataTelClient));
          int numero_de_voie_client=Integer.parseInt(String.valueOf(dataNumVoieClient));
            
          myClient=new Client(dataNomClient,dataPrenomClient,numero_de_tel_client,dataMailClient,numero_de_voie_client,dataAdresseClient,dataVilleClient,dataPaysClient,dataMdpClient);
          System.out.println(myClient.toString());
          
          listeClients.add(myClient);
          //afficherListeClients(listeClients);
          
          JOptionPane.showMessageDialog(null,"Votre compte a été créé avec succès");
          super.dispose();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textNomClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomClientKeyPressed
      String nom=textNomClient.getText();
        
        int tailleNom=nom.length();
        
        char verifNom=evt.getKeyChar();
        
            if(tailleNom<30){
                
               if((verifNom>='0') && (verifNom<='9'))
                {
                textNomClient.setEditable(false);
                }else
               {
                   textNomClient.setEditable(true);
               }
               
            }else
            {     
        
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textNomClient.setEditable(true);
           }else
           {
               textNomClient.setEditable(false);
           }
        } 
    }//GEN-LAST:event_textNomClientKeyPressed

    private void textPrenomClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrenomClientKeyPressed
        String prenom=textPrenomClient.getText();
        
        int taillePrenom=prenom.length();
        
            if(taillePrenom<30){
                textPrenomClient.setEditable(true);
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textPrenomClient.setEditable(true);
           }else
           {
               textPrenomClient.setEditable(false);
           }
            }
    }//GEN-LAST:event_textPrenomClientKeyPressed

    private void textTelClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelClientKeyPressed
       String numTel=textTelClient.getText();
        
        int tailleNumTel=numTel.length();
        
        char verifNum=evt.getKeyChar();
        
        if((verifNum>='0') && (verifNum<='9'))
        {
            if(tailleNumTel<10){
                textTelClient.setEditable(true);
            }else
            {
                textTelClient.setEditable(false);
            }
        }else
        {
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textTelClient.setEditable(true);
           }else
           {
               textTelClient.setEditable(false);
           }
        }   
    }//GEN-LAST:event_textTelClientKeyPressed

    private void textMailClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMailClientKeyPressed
  String mail=textMailClient.getText();
        
        int tailleMail=mail.length();
        
            if(tailleMail<50){
                textMailClient.setEditable(true);
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textMailClient.setEditable(true);
           }else
           {
               textMailClient.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textMailClientKeyPressed

    private void textNumVoieClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumVoieClientKeyPressed
       String numVoie=textNumVoieClient.getText();
        
        int tailleNumVoie=numVoie.length();
        
        char verifNumVoie=evt.getKeyChar();
        
        if((verifNumVoie>='0') && (verifNumVoie<='9'))
        {
            if(tailleNumVoie<4){
                textNumVoieClient.setEditable(true);
            }else
            {
                textNumVoieClient.setEditable(false);
            }
        }else
        {
           if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textNumVoieClient.setEditable(true);
           }else
           {
               textNumVoieClient.setEditable(false);
           }
        }   
    }//GEN-LAST:event_textNumVoieClientKeyPressed

    private void textAdresseClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAdresseClientKeyPressed
  String adresse=textAdresseClient.getText();
        
        int tailleAdresse=adresse.length();
        
        char verifAdresse=evt.getKeyChar();
        
            if(tailleAdresse<50){
                
               if((verifAdresse>='0') && (verifAdresse<='9'))
                {
                textAdresseClient.setEditable(false);
                }else
               {
                   textAdresseClient.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textAdresseClient.setEditable(true);
           }else
           {
               textAdresseClient.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textAdresseClientKeyPressed

    private void textVilleClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textVilleClientKeyPressed
        String ville=textVilleClient.getText();
        
        int tailleVille=ville.length();
        
        char verifVille=evt.getKeyChar();
        
            if(tailleVille<30){
                
               if((verifVille>='0') && (verifVille<='9'))
                {
                textVilleClient.setEditable(false);
                }else
               {
                   textVilleClient.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textVilleClient.setEditable(true);
           }else
           {
               textVilleClient.setEditable(false);
           }
            } 
    }//GEN-LAST:event_textVilleClientKeyPressed

    private void textPaysClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPaysClientKeyPressed
        String pays=textPaysClient.getText();
        
        int taillePays=pays.length();
        
        char verifPays=evt.getKeyChar();
        
            if(taillePays<30){
                
               if((verifPays>='0') && (verifPays<='9'))
                {
                textPaysClient.setEditable(false);
                }else
               {
                   textPaysClient.setEditable(true);
               }
               
            }else
            {
                  if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textPaysClient.setEditable(true);
           }else
           {
               textPaysClient.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textPaysClientKeyPressed

    private void textMdpClientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMdpClientKeyPressed
      String mdp=textMdpClient.getText();
        
        int tailleMdp=mdp.length();
        
            if(tailleMdp<12){
                textMdpClient.setEditable(true);
            }else
            {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ||evt.getExtendedKeyCode()==KeyEvent.VK_TAB) 
           {
               textMdpClient.setEditable(true);
           }else
           {
               textMdpClient.setEditable(false);
           }
            }  
    }//GEN-LAST:event_textMdpClientKeyPressed

    
    //afficher la liste de tous les clients de la base de données
    public void afficherListeClients(ArrayList<Client> listeClients) {
        System.out.println("La liste des clients est:");
        for (int i = 0; i < listeClients.size(); i++) {
            System.out.println(listeClients.get(i).toString());
        }
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textAdresseClient;
    private javax.swing.JTextField textMailClient;
    private javax.swing.JTextField textMdpClient;
    private javax.swing.JTextField textNomClient;
    private javax.swing.JTextField textNumVoieClient;
    private javax.swing.JTextField textPaysClient;
    private javax.swing.JTextField textPrenomClient;
    private javax.swing.JTextField textTelClient;
    private javax.swing.JTextField textVilleClient;
    // End of variables declaration//GEN-END:variables
    private Connexion maconnexion;
    private Client myClient;
    private ArrayList<Client> listeClients=new ArrayList<Client>();
}

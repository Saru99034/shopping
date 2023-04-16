/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;

import Connexion.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // pour ActionEvent et ActionListener
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author USER
 */
public class Home extends javax.swing.JFrame {

   Panier p= new Panier(); //La classe Home contient un panier 
   ArrayList<Article> list_article = new ArrayList(); //contient une liste de tous les articles du magasin
       private String mailAdress;  
      
   
    //.....setters et getters....
        public ArrayList<Article> getArticleList() {
        return this.list_article;
    }
           public Panier getPanierList() {
        return this.p;
    } 
           public void setArticleList(ArrayList<Article> arrayList) {
        this.list_article = arrayList;
    }
           
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    /**
     * Creates new form Home
     */
    public Home() {
        chargerArticles();
        initComponents();
        dateHeure();
        textBienvenue.setVisible(false);
        textNom.setVisible(false);
        textPrenom.setVisible(false);
        buttonDeco.setVisible(false);
    }

     public Home(String adresseMail) {
        chargerArticles();
        initComponents();
        dateHeure();
        jButton7.setVisible(false);
        jButton9.setVisible(false);
        textBienvenue.setVisible(false);
        textNom.setVisible(false);
        textPrenom.setVisible(false);
        buttonDeco.setVisible(false);
        this.mailAdress = adresseMail;
        nomClient();
        prenomClient();
        nomEmploye();
        prenomEmploye();
    }
     
       //accesseur de l'adresse mail client
    public String getMailAdress() {
        return this.mailAdress;
    }
    
      public void connexionArticle()
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
        // sous programme pour avoir la date actuelle et l'heure actuelle
    public void dateHeure() {
        Thread tr = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Calendar calendrier = new GregorianCalendar();

                        int annee = calendrier.get(Calendar.YEAR);
                        int mois = calendrier.get(Calendar.MONTH);
                        int jour = calendrier.get(Calendar.DAY_OF_MONTH);

                        int heure = calendrier.get(Calendar.HOUR_OF_DAY);
                        int minute = calendrier.get(Calendar.MINUTE);
                        int seconde = calendrier.get(Calendar.SECOND);

                        mois = mois + 1;
                        textDate.setText(jour + "/" + mois + "/" + annee);
                        textHeure.setText(heure + ":" + minute + ":" + seconde);
                        sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        tr.start();

    }
    
    public void nomClient() {
        
                    try {
                        connexionArticle();
                        String requeteSelectNom = "SELECT client_nom FROM client WHERE client_mail=?";
                        pst = con.prepareStatement(requeteSelectNom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            textNom.setText(rs.getString("client_nom").toUpperCase());
                            textBienvenue.setVisible(true);
                            textNom.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
         

    }

    public void prenomClient() {
                    try {
                        connexionArticle();
                        String requeteSelectPrenom = "SELECT client_prenom FROM client WHERE client_mail=?";
                        pst = con.prepareStatement(requeteSelectPrenom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            textPrenom.setText(rs.getString("client_prenom"));
                            textPrenom.setVisible(true);
                            buttonDeco.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

    }

    public void nomEmploye() {
                    try {
                        connexionArticle();
                        String requeteSelectNom = "SELECT employe_nom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectNom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            textNom.setText(rs.getString("employe_nom").toUpperCase());
                            textBienvenue.setVisible(true);
                            textNom.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

    }

    public void prenomEmploye() {
        
                    try {
                        connexionArticle();
                        String requeteSelectPrenom = "SELECT employe_prenom FROM employe WHERE employe_mail=?";
                        pst = con.prepareStatement(requeteSelectPrenom);
                        pst.setString(1, getMailAdress());
                        rs = pst.executeQuery();

                        while (rs.next()) {
                            textPrenom.setText(rs.getString("employe_prenom"));
                            textPrenom.setVisible(true);
                            buttonDeco.setVisible(true);
                            // textNomClientBis.setEditable(false);
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

    }
      
      
      //..........CHARGE TOUS MES ARTICLES.............
    
       public void chargerArticles(){
        try{
          connexionArticle();
          pst=con.prepareStatement("SELECT * FROM article");  //requête de recuperation d'article
          rs=pst.executeQuery();
          
          while(rs.next()) {
                // Récupération des valeurs de la bdd
                String marque = rs.getString("marque");
                int prix_u = rs.getInt("prix_unitaire");
                int prix_p = rs.getInt("prix_pack");
                int quantite_p = rs.getInt("Quantite_Pack");
                int reference = rs.getInt("reference");
                int stock = rs.getInt("stock");
                String desc = rs.getString("Description");
                 String img = rs.getString("image");
                
                Article a = new Article(marque, prix_u, prix_p,quantite_p, reference, stock,desc,img);
                list_article.add(a);
                
          
               // System.out.println( ", Marque : " + marque + ",  Prix U : " + prix_u + ", Prix P : " + prix_p + ", Reference : " + reference + ", Stock : " + stock + ", Desc:"+ desc + ", QT : "+quantite_p);
            }
        } catch (SQLException e) {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_marque1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BPant = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        buttonDeco = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        textDate = new javax.swing.JLabel();
        textHeure = new javax.swing.JLabel();
        textBienvenue = new javax.swing.JLabel();
        textNom = new javax.swing.JLabel();
        textPrenom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("./image/pentalon.jpg"));

        jLabel2.setIcon(new javax.swing.ImageIcon("./image/veste.jpg"));

        jLabel3.setIcon(new javax.swing.ImageIcon("./image/sac.jpg"));

        jLabel_marque1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        String txt =new String();
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==1)
            {
                txt = list_article.get(i).getMarque();
            }
        }
        jLabel_marque1.setText(txt);

        jLabel5.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==1)
            {
                txt = list_article.get(i).getDescription();
            }
        }
        jLabel5.setText(txt);

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==2)
            {
                txt = list_article.get(i).getMarque();
            }
        }
        jLabel6.setText(txt);

        jLabel7.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==2)
            {
                txt = list_article.get(i).getDescription();
            }
        }
        jLabel7.setText(txt);

        jLabel8.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==3)
            {
                txt = list_article.get(i).getMarque();
            }
        }
        jLabel8.setText(txt);

        jLabel9.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==3)
            {
                txt = list_article.get(i).getDescription();
            }
        }
        jLabel9.setText(txt);

        jLabel10.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        int prix1 = 0;
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==1)
            {
                prix1 = list_article.get(i).getPrix_unitaire();
            }
        }
        txt = Integer.toString(prix1);
        jLabel10.setText(txt + " €");

        jLabel11.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==2)
            {
                prix1 = list_article.get(i).getPrix_unitaire();
            }
        }
        txt = Integer.toString(prix1);
        jLabel11.setText(txt + " €");

        jLabel12.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==3)
            {
                prix1 = list_article.get(i).getPrix_unitaire();
            }
        }
        txt = Integer.toString(prix1);
        jLabel12.setText(txt + " €");

        BPant.setIcon(new javax.swing.ImageIcon("./image/iconeCad.png"));
        BPant.setBorderPainted(false);
        BPant.setContentAreaFilled(false);
        BPant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BPantMouseClicked(evt);
            }
        });
        BPant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPantActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("./image/iconeCad.png"));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("./image/iconeCad.png"));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon("./image/lunette.jpg"));

        jLabel14.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==4)
            {
                txt = list_article.get(i).getMarque();
            }
        }
        jLabel14.setText(txt);

        jLabel15.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==4)
            {
                txt = list_article.get(i).getDescription();
            }
        }
        jLabel15.setText(txt);

        jLabel16.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==4)
            {
                prix1 = list_article.get(i).getPrix_unitaire();
            }
        }
        txt = Integer.toString(prix1);
        jLabel16.setText(txt + " €");

        jButton4.setIcon(new javax.swing.ImageIcon("./image/iconeCad.png"));
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon("./image/bonnet.jpg"));

        jLabel18.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==5)
            {
                txt = list_article.get(i).getMarque();
            }
        }
        jLabel18.setText(txt);

        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==5)
            {
                txt = list_article.get(i).getDescription();
            }
        }
        jLabel19.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        jLabel19.setText(txt);

        jLabel20.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        for(int i=0;i<list_article.size(); i++)
        {
            if(list_article.get(i).getRef()==5)
            {
                prix1 = list_article.get(i).getPrix_unitaire();
            }
        }
        txt = Integer.toString(prix1);
        jLabel20.setText(txt + " €");

        jButton5.setIcon(new javax.swing.ImageIcon("./image/iconeCad.png"));
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        buttonDeco.setBackground(new java.awt.Color(0, 0, 0));
        buttonDeco.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        buttonDeco.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeco.setText("Se Deconnecter");
        buttonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_marque1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BPant)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(92, 92, 92)
                                .addComponent(jButton3))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(jLabel16)
                        .addGap(109, 109, 109)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDeco)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_marque1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel19))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(BPant, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1))
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jButton4)
                                    .addComponent(jLabel20)))
                            .addComponent(jButton5)))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(buttonDeco)
                .addGap(134, 134, 134))
        );

        jLabel21.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel21.setText("BOUTIQUE");

        jButton6.setIcon(new javax.swing.ImageIcon("./image/iconSac.png"));
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("./image/iconUtilisateur.png"));
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon("./image/IconAdmin.png"));
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton8.setText("Pantalons");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton10.setText("Chaussures");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);

        jButton11.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton11.setText("Sacs");
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton12.setText("Accessoires");
        jButton12.setToolTipText("");
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        jTextField2.setText("Recherche");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton13.setText("Robes");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);

        jButton14.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton14.setText("Vestes");
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        textDate.setText("date");

        textHeure.setText("heure");

        textBienvenue.setText("Bienvenue");

        textNom.setText("nom");

        textPrenom.setText("prenom");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(textDate)
                        .addGap(18, 18, 18)
                        .addComponent(textHeure))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textBienvenue)
                        .addGap(18, 18, 18)
                        .addComponent(textNom)
                        .addGap(18, 18, 18)
                        .addComponent(textPrenom)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(387, 387, 387)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDate)
                                    .addComponent(textHeure))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textBienvenue)
                                    .addComponent(textNom)
                                    .addComponent(textPrenom))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton13)
                            .addComponent(jButton14)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton12))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addComponent(jButton9)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPantActionPerformed
      
    }//GEN-LAST:event_BPantActionPerformed

    //.........CLIQUE SUR MES PANIERS.......
    
    private void BPantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BPantMouseClicked

        //fenetre pour choisir nombre d'article va s'afficher
    int ref=0; //c'est l'article 0 de ma liste d'article qui a été sélectionné 
  
    Poppup_Panier  page=new Poppup_Panier();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe
    page.setArticleList(list_article);
    page.setPanierList(p);
    page.setRef(ref);
    page.setVisible(true);
    
    }//GEN-LAST:event_BPantMouseClicked

   
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
              //fenetre pour choisir nombre d'article va s'afficher
    int ref=1; //c'est l'article 0 de ma liste d'article qui a été sélectionné 
  
    Poppup_Panier  page=new Poppup_Panier();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe
    page.setArticleList(list_article);
  
    page.setPanierList(p);
    page.setRef(ref);
    page.setVisible(true);
      System.out.println( "........... ");
   /* for(int i=0; i<p.getListSize(); i++)
    {
        System.out.println( ", Marque : " + p.getArrayList().get(i).getMarque() );
    }*/

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
    
           //fenetre pour choisir nombre d'article va s'afficher
    int ref=2; //c'est l'article 0 de ma liste d'article qui a été sélectionné 
  
    Poppup_Panier  page=new Poppup_Panier();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe
    page.setArticleList(list_article);

    page.setPanierList(p);
   page.setRef(ref);
    
    page.setVisible(true);
    /*  System.out.println( "........... ");
    for(int i=0; i<p.getListSize(); i++)
    {
        System.out.println( ", Marque : " + p.getArrayList().get(i).getMarque() );
    }*/
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
                 //fenetre pour choisir nombre d'article va s'afficher
    int ref=3; //c'est l'article 0 de ma liste d'article qui a été sélectionné 
  
    Poppup_Panier  page=new Poppup_Panier();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe
   page.setArticleList(list_article);
  
    page.setPanierList(p);
    page.setRef(ref);
    
    page.setVisible(true);
      System.out.println( "........... ");
    /*for(int i=0; i<p.getListSize(); i++)
    {
        System.out.println( ", Marque : " + p.getArrayList().get(i).getMarque() );
    }*/
    
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
              //fenetre pour choisir nombre d'article va s'afficher
    int ref=4; //c'est l'article 0 de ma liste d'article qui a été sélectionné 
  //  super.dispose();
    Poppup_Panier  page=new Poppup_Panier();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe
    page.setArticleList(list_article);
    page.setPanierList(p);
    page.setRef(ref);
    
    page.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    //.........clique sur le panier.......
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
          

  PanierFrame page=new PanierFrame();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
   
    //on envoie les élements à ma classe

    page.setPanierList(p);
    page.Panier2();
    
    page.setVisible(true);
   
    }//GEN-LAST:event_jButton6MouseClicked

  
    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked

    }//GEN-LAST:event_jButton7MouseClicked

    //.....clique sur bouton employé.....
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     PageConnexionEmploye page=new PageConnexionEmploye();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
    page.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed
  //.........clique sur l'utilisateur.......
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //si utilisateur pas encore connecté afficher fenetre de choix
    PageConnexionClient page=new PageConnexionClient();
    page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //permet de fermer que cette page
    page.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    //.....DECONNECTION.......
    private void buttonDecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDecoActionPerformed
        Home.super.dispose();
        connexionArticle();

        Home homepage = new Home();
        homepage.chargerArticles();
        homepage.setVisible(true);
    }//GEN-LAST:event_buttonDecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
      Home h = new Home();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                h.setVisible(true);
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BPant;
    private javax.swing.JButton buttonDeco;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_marque1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel textBienvenue;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textHeure;
    private javax.swing.JLabel textNom;
    private javax.swing.JLabel textPrenom;
    // End of variables declaration//GEN-END:variables
}

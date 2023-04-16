/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fenetre;


import Connexion.Panier;
import javax.swing.JList;
import Connexion.Article;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author USER
 */
public class PanierFrame extends javax.swing.JFrame {
    
   private String adressMail;
       Panier pan= new Panier(getAdresseMail()); //Je récupère le panier
  
       //Panier pan= new Panier(); //Je récupère le panier
  

       int ref=0;
       int prix=0;
       
        public Panier setPanierList(Panier p) {
        return pan=p;
    } 
        
         private int index;
    /**
      
       
    /**
     * Creates new form Panier
     * @return 
     */
    public PanierFrame() {
     
        initComponents();
         //  Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ " "+pan.getArrayList().get(0).getDescription());
         dateHeure();
    }
    
      public PanierFrame(String adresseMail)
    {
        initComponents();
        this.adressMail=adresseMail;
        dateHeure();
        this.index=rechercheIndexClient();
    }
    
       public String getAdresseMail()
    {
        return this.adressMail;
    }
    
    public int getIndex()
    {
        return this.index;
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
                        //textDate.setText(jour + "/" + mois + "/" + annee);
                       // textHeure.setText(heure + ":" + minute + ":" + seconde);
                        sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        tr.start();

    }
    
    public int rechercheIndexClient()
    {
        try {
                        
                        connexion();
                        String sqlSelectIndexClient = "SELECT id_client from client WHERE client_mail=?";
                        pst = con.prepareStatement(sqlSelectIndexClient);
                        pst.setString(1, getAdresseMail());
                        rs = pst.executeQuery();

                        while(rs.next()) {
                           // comboBoxMarque.addItem(rs.getString("marque"));
                           index=rs.getInt("id_client");

                        }
                        con.close();

                       // return index;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
           return index;
        
    }
    
    public void Panier2()
    {
        if(pan.getListSize()>0) //si panier pas vide
        {
           if(pan.getListSize()==1)
           {
                Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ "            "+pan.getArrayList().get(0).getDescription()+ "    Quantité: x"+pan.getArrayList().get(0).getQt_client()+"         Prix: "+pan.getArrayList().get(0).getPrix_client()+"€");
           }else  if(pan.getListSize()==2)
           {
                     Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ "            "+pan.getArrayList().get(0).getDescription()+ "    Quantité: x"+pan.getArrayList().get(0).getQt_client()+  "          Prix: "+pan.getArrayList().get(0).getPrix_client()+"€");
                     Article2.setText(" "+pan.getArrayList().get(1).getMarque()+ "            "+pan.getArrayList().get(1).getDescription()+ "    Quantité: x"+pan.getArrayList().get(1).getQt_client()+"            Prix: "+pan.getArrayList().get(1).getPrix_client()+"€");
          
           }else  if(pan.getListSize()==3)
           {
                     Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ "            "+pan.getArrayList().get(0).getDescription()+ "    Quantité: x"+pan.getArrayList().get(0).getQt_client()+"            Prix: "+pan.getArrayList().get(0).getPrix_client()+"€");
                     Article2.setText(" "+pan.getArrayList().get(1).getMarque()+ "            "+pan.getArrayList().get(1).getDescription()+ "    Quantité: x"+pan.getArrayList().get(1).getQt_client()+"            Prix: "+pan.getArrayList().get(1).getPrix_client()+"€");
                     Article3.setText(" "+pan.getArrayList().get(2).getMarque()+ "            "+pan.getArrayList().get(2).getDescription()+ "    Quantité: x"+pan.getArrayList().get(2).getQt_client()+"            Prix: "+pan.getArrayList().get(2).getPrix_client()+"€");
          
           }else  if(pan.getListSize()==4)
           {
                     Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ "            "+pan.getArrayList().get(0).getDescription()+ "    Quantité: x"+pan.getArrayList().get(0).getQt_client()+"            Prix: "+pan.getArrayList().get(0).getPrix_client()+"€");
                     Article2.setText(" "+pan.getArrayList().get(1).getMarque()+ "            "+pan.getArrayList().get(1).getDescription()+ "    Quantité: x"+pan.getArrayList().get(1).getQt_client()+"            Prix: "+pan.getArrayList().get(1).getPrix_client()+"€");
                     Article3.setText(" "+pan.getArrayList().get(2).getMarque()+ "            "+pan.getArrayList().get(2).getDescription()+ "    Quantité: x"+pan.getArrayList().get(2).getQt_client()+"            Prix: "+pan.getArrayList().get(2).getPrix_client()+"€");
                     Article4.setText(" "+pan.getArrayList().get(3).getMarque()+ "            "+pan.getArrayList().get(3).getDescription()+ "    Quantité: x"+pan.getArrayList().get(3).getQt_client()+"            Prix: "+pan.getArrayList().get(3).getPrix_client()+"€");
                   
           }else //5 artcles
           {
                Article1.setText(" "+pan.getArrayList().get(0).getMarque()+ "            "+pan.getArrayList().get(0).getDescription()+ "    Quantité: x"+pan.getArrayList().get(0).getQt_client()+"         Prix: x"+pan.getArrayList().get(0).getPrix_client()+"€");
                     Article2.setText(" "+pan.getArrayList().get(1).getMarque()+ "            "+pan.getArrayList().get(1).getDescription()+ "    Quantité: x"+pan.getArrayList().get(1).getQt_client()+"            Prix: "+pan.getArrayList().get(1).getPrix_client()+"€");
                     Article3.setText(" "+pan.getArrayList().get(2).getMarque()+ "            "+pan.getArrayList().get(2).getDescription()+ "    Quantité: x"+pan.getArrayList().get(2).getQt_client()+"            Prix: "+pan.getArrayList().get(2).getPrix_client()+"€");
                     Article4.setText(" "+pan.getArrayList().get(3).getMarque()+ "            "+pan.getArrayList().get(3).getDescription()+ "    Quantité: x"+pan.getArrayList().get(3).getQt_client()+"            Prix: "+pan.getArrayList().get(3).getPrix_client()+"€");
                     Article5.setText(" "+pan.getArrayList().get(4).getMarque()+ "            "+pan.getArrayList().get(4).getDescription()+ "    Quantité: x"+pan.getArrayList().get(4).getQt_client()+"            Prix: "+pan.getArrayList().get(4).getPrix_client()+"€");
                   
           }
           
        }
          
        //afficher prix total
        LabelTot.setText("Total: "+pan.getPrix());
    }
    
    //........................CONNEXION BDD.......................
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LabelTot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Article1 = new javax.swing.JLabel();
        Article2 = new javax.swing.JLabel();
        Article3 = new javax.swing.JLabel();
        Article4 = new javax.swing.JLabel();
        Article5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1290, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(1290, 766));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel1.setText("PANIER");

        jLabel2.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        jLabel2.setText("Récapitulatif");

        LabelTot.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Passer au paiement");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Article1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        Article1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Article1MouseClicked(evt);
            }
        });

        Article2.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N

        Article3.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N

        Article4.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N

        Article5.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N

        jToggleButton1.setIcon(new javax.swing.ImageIcon("./image/IconTrash.png"));
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon("./image/IconTrash.png"));
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon("./image/IconTrash.png"));
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setDefaultCapable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon("./image/IconTrash.png"));
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon("./image/IconTrash.png"));
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon("./image/IconStylo.png"));
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon("./image/IconStylo.png"));
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon("./image/IconStylo.png"));
        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon("./image/IconStylo.png"));
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon("./image/IconStylo.png"));
        jButton20.setBorderPainted(false);
        jButton20.setContentAreaFilled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Article5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Article4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                                .addComponent(Article3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Article1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Article2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jSpinner4)
                            .addComponent(jSpinner5)
                            .addComponent(jSpinner2)
                            .addComponent(jSpinner1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17)
                            .addComponent(jButton20)
                            .addComponent(jButton15)
                            .addComponent(jButton16)
                            .addComponent(jButton18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14)
                            .addComponent(jButton12)
                            .addComponent(jButton13))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(LabelTot, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton11)
                    .addComponent(jToggleButton1))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Article1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton15)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Article2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Article3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton16)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(Article5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton18))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Article4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton20))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(LabelTot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Sitka Small", 1, 36)); // NOI18N
        jLabel4.setText("BOUTIQUE");

        jButton2.setIcon(new javax.swing.ImageIcon("./image/iconSac.png"));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);

        jButton3.setIcon(new javax.swing.ImageIcon("./image/iconUtilisateur.png"));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);

        jButton4.setIcon(new javax.swing.ImageIcon("./image/IconAdmin.png"));
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);

        jButton5.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton5.setText("Pentalons");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);

        jButton6.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton6.setText("Robes");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);

        jButton7.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton7.setText("Vestes");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);

        jButton8.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton8.setText("Chaussures");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);

        jButton9.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton9.setText("Sacs");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);

        jButton10.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        jButton10.setText("Accessoires");
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);

        jTextField1.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        jTextField1.setText("Recherche");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(jButton7)
                        .addComponent(jButton8)
                        .addComponent(jButton9)
                        .addComponent(jButton10))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    //...si je clique sur article je peux modifier la quantité....
    private void Article1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Article1MouseClicked
     
  
   
    
    }//GEN-LAST:event_Article1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        //recalcul du prix tot
      pan.setPrix(pan.getPrix()-pan.getArrayList().get(0).getPrix_client()); //mettre à jour le prix total du panier
       pan.getArrayList().remove(0); //on suprime de la liste article selectionné 
       JOptionPane.showMessageDialog(this, "Article supprimé");
      super.dispose();
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
            //recalcul du prix tot
      pan.setPrix(pan.getPrix()-pan.getArrayList().get(4).getPrix_client()); //mettre à jour le prix total du panier
       pan.getArrayList().remove(4); //on suprime de la liste article selectionné 
       JOptionPane.showMessageDialog(this, "Article supprimé");
       super.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
           //recalcul du prix tot
      pan.setPrix(pan.getPrix()-pan.getArrayList().get(1).getPrix_client()); //mettre à jour le prix total du panier
       pan.getArrayList().remove(1); //on suprime de la liste article selectionné 
       JOptionPane.showMessageDialog(this, "Article supprimé");
       super.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
            //recalcul du prix tot
      pan.setPrix(pan.getPrix()-pan.getArrayList().get(2).getPrix_client()); //mettre à jour le prix total du panier
       pan.getArrayList().remove(2); //on suprime de la liste article selectionné 
       JOptionPane.showMessageDialog(this, "Article supprimé");
       super.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
            //recalcul du prix tot
      pan.setPrix(pan.getPrix()-pan.getArrayList().get(3).getPrix_client()); //mettre à jour le prix total du panier
       pan.getArrayList().remove(3); //on suprime de la liste article selectionné 
       JOptionPane.showMessageDialog(this, "Article supprimé");
       super.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed
 //...methode qui calcul le prix...
    public void prix(int nb, Article a)
    {
        int tmp=0;
        
        if(nb<a.getQuantite_pack()) //si pas assez d'articles pour promo
        {
            for(int i=0; i<nb; i++)
        {
            prix+= a.getPrix_unitaire(); //on additionne 
        }
        }else //si promo
        {
            tmp=(nb/a.getQuantite_pack()); // pour savoir à combien de reductions j'ai le droit
            tmp=(tmp*a.getQuantite_pack()); // pour savoir sur combien d'articles j'ai la reduction
            
            //calcul le prix
            for(int i=0; i<tmp; i++)
            {
                 prix+= a.getPrix_pack(); //on additionne avec promo
            }
            
            for(int i=0; i<nb-tmp; i++)
            {
                  prix+= a.getPrix_unitaire(); //on additionne avec le reste hors pormo
            }
        }
        
        //System.out.println( "Prix : "+ prix+ " nb:"+nb);
      //  jLabelPrix.setText(" "+prix);
        
        
    }
    //....MODIFIER QUANTITE PANIER.......
    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
     
    }//GEN-LAST:event_jSpinner1StateChanged

    
    //.......j'appuie sur modifier du 1 er article....
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
           //verifier le nombre d'article
        
       int verifNum= (int) jSpinner1.getValue(); //récupère valeur du spinner
   
       
       if((verifNum<= 0)|| (verifNum>pan.getArrayList().get(0).getStock()) ) //si la quantité sélectionné dépasse le stock ou est inférieur à 0
        {
             JOptionPane.showMessageDialog(this, "Veuillez changer la quantité");
        }else //sinon ajouter dans panier
        {
        
           pan.setPrix(pan.getPrix()-pan.getArrayList().get(0).getPrix_client()); //enlève article du pris tot
         //calculer nouveau prix
        prix(verifNum,pan.getArrayList().get(0)); //on calcul le prix
      
       pan.getArrayList().get(0).setQt_client(verifNum);  //modifie nb d'articles
       pan.getArrayList().get(0).setPrix_client(prix);//modifie prix tot pour cet article
       //mettre à jour le prix total du panier
      
       pan.setPrix(pan.getPrix()+prix);
      
           
        // afficher message
       JOptionPane.showMessageDialog(this, "L'article a été modifié!");
       super.dispose();
        }  
   
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
           int verifNum= (int) jSpinner2.getValue(); //récupère valeur du spinner
   
       
       if((verifNum<= 0)|| (verifNum>pan.getArrayList().get(1).getStock()) ) //si la quantité sélectionné dépasse le stock ou est inférieur à 0
        {
             JOptionPane.showMessageDialog(this, "Veuillez changer la quantité");
        }else //sinon ajouter dans panier
        {
        
           pan.setPrix(pan.getPrix()-pan.getArrayList().get(1).getPrix_client()); //enlève article du pris tot
         //calculer nouveau prix
        prix(verifNum,pan.getArrayList().get(1)); //on calcul le prix
      
       pan.getArrayList().get(1).setQt_client(verifNum);  //modifie nb d'articles
       pan.getArrayList().get(1).setPrix_client(prix);//modifie prix tot pour cet article
       //mettre à jour le prix total du panier
      
       pan.setPrix(pan.getPrix()+prix);
      
           
        // afficher message
       JOptionPane.showMessageDialog(this, "L'article a été modifié!");
       super.dispose();
        }  
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        int verifNum= (int) jSpinner3.getValue(); //récupère valeur du spinner
   
       
       if((verifNum<= 0)|| (verifNum>pan.getArrayList().get(2).getStock()) ) //si la quantité sélectionné dépasse le stock ou est inférieur à 0
        {
             JOptionPane.showMessageDialog(this, "Veuillez changer la quantité");
        }else //sinon ajouter dans panier
        {
        
           pan.setPrix(pan.getPrix()-pan.getArrayList().get(2).getPrix_client()); //enlève article du pris tot
         //calculer nouveau prix
        prix(verifNum,pan.getArrayList().get(2)); //on calcul le prix
      
       pan.getArrayList().get(2).setQt_client(verifNum);  //modifie nb d'articles
       pan.getArrayList().get(2).setPrix_client(prix);//modifie prix tot pour cet article
       //mettre à jour le prix total du panier
      
       pan.setPrix(pan.getPrix()+prix);
      
           
        // afficher message
       JOptionPane.showMessageDialog(this, "L'article a été modifié!");
       super.dispose();
        }  
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
         int verifNum= (int) jSpinner4.getValue(); //récupère valeur du spinner
   
       
       if((verifNum<= 0)|| (verifNum>pan.getArrayList().get(2).getStock()) ) //si la quantité sélectionné dépasse le stock ou est inférieur à 0
        {
             JOptionPane.showMessageDialog(this, "Veuillez changer la quantité");
        }else //sinon ajouter dans panier
        {
        
           pan.setPrix(pan.getPrix()-pan.getArrayList().get(3).getPrix_client()); //enlève article du pris tot
         //calculer nouveau prix
        prix(verifNum,pan.getArrayList().get(3)); //on calcul le prix
      
       pan.getArrayList().get(3).setQt_client(verifNum);  //modifie nb d'articles
       pan.getArrayList().get(3).setPrix_client(prix);//modifie prix tot pour cet article
       //mettre à jour le prix total du panier
      
       pan.setPrix(pan.getPrix()+prix);
      
           
        // afficher message
       JOptionPane.showMessageDialog(this, "L'article a été modifié!");
       super.dispose();
        }  
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
          int verifNum= (int) jSpinner5.getValue(); //récupère valeur du spinner
   
       
       if((verifNum<= 0)|| (verifNum>pan.getArrayList().get(4).getStock()) ) //si la quantité sélectionné dépasse le stock ou est inférieur à 0
        {
             JOptionPane.showMessageDialog(this, "Veuillez changer la quantité");
        }else //sinon ajouter dans panier
        {
        
           pan.setPrix(pan.getPrix()-pan.getArrayList().get(4).getPrix_client()); //enlève article du pris tot
         //calculer nouveau prix
        prix(verifNum,pan.getArrayList().get(4)); //on calcul le prix
      
       pan.getArrayList().get(4).setQt_client(verifNum);  //modifie nb d'articles
       pan.getArrayList().get(4).setPrix_client(prix);//modifie prix tot pour cet article
       //mettre à jour le prix total du panier
      
       pan.setPrix(pan.getPrix()+prix);
      
           
        // afficher message
       JOptionPane.showMessageDialog(this, "L'article a été modifié!");
       super.dispose();
       
        }  
    }//GEN-LAST:event_jButton18ActionPerformed

    
    //..........PAYER LA COMMANDE..........
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
       // JOptionPane d = new JOptionPane();
     //  JOptionPane d = new JOptionPane(); 
       int retour=  JOptionPane.showConfirmDialog(this, "Vous validez votre commande?","Paiement", JOptionPane.OK_CANCEL_OPTION);
      if( retour==JOptionPane.OK_OPTION) //si client valide le paiement
      {
          //on enregistre commande dans la base de donnée
             // TODO add your handling code here:
         try{
          connexion();
          
          for(int i=0; i<pan.getListSize(); i++)
          {
             
         String dataArticle=pan.getArrayList().get(i).getMarque();
         String dataPrixArticle=Integer.toString(pan.getArrayList().get(i).getPrix_client());
         String dataQuantite=Integer.toString(pan.getArrayList().get(i).getQt_client());
         String dataPrixTot=Integer.toString(pan.getPrix());
         //String datamail="0"; //à modifier CONNECTER ICI
            String dataIndex=Integer.toString(getIndex());
            
          String requeteInsertionArticle="INSERT INTO commande(ID,Articles,Quantite,Prix_Articles,Prix_Total,id_client) VALUES(NULL,?,?,?,?,?)";
          
          pst=con.prepareStatement(requeteInsertionArticle);
         
          pst.setString(1,dataArticle);
          pst.setString(2,dataQuantite);
          pst.setString(3,dataPrixArticle);
          pst.setString(4,dataPrixTot);
          //pst.setString(5,datamail);
          pst.setString(5,dataIndex);
          
              System.out.println(" "+dataArticle+ " "+dataQuantite+ " "+ dataPrixArticle+ " "+ dataPrixTot+ " "+getAdresseMail() );
          int row=pst.executeUpdate();
          
          }
          
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
            JOptionPane.showMessageDialog(this, "Boutique vous remercie pour votre achat!");
            super.dispose();
      }else if( retour==JOptionPane.CANCEL_OPTION) //si client valide le paiement
      {
            JOptionPane.showMessageDialog(this, "Commande annulée!");
            super.dispose();
       
      }
      
       //   JOptionPane.showMessageDialog(this, "Vous validez votre commande?");
        
    }//GEN-LAST:event_jButton1ActionPerformed


 
    
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
            java.util.logging.Logger.getLogger(PanierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanierFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        PanierFrame h = new PanierFrame();
        
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {   
              
               h.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Article1;
    private javax.swing.JLabel Article2;
    private javax.swing.JLabel Article3;
    private javax.swing.JLabel Article4;
    private javax.swing.JLabel Article5;
    private javax.swing.JLabel LabelTot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

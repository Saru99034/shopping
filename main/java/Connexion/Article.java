/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author valen
 */
public class Article {
    
    //attributs
    private String marque;
    private int prix_unitaire;
    private int prix_pack;
    private int quantite_pack;
    private int ref;
    private int stock;
    private String description;
    private int qt_client; //nb d'articles que le client va vouloir acheter
    private int prix_client; //combien ca va couter au client pour cet article en fct de la quantité
    
    //constructeur
    public Article(String m,int pu, int pp,int qp,int r, int s, String d){
     
        this.marque=m;
        this.prix_unitaire=pu;
        this.prix_pack=pp;
        this.quantite_pack=qp;
        this.ref=r;
        this.stock=s;
        this.description=d;
        this.qt_client=0; //initialisé à 0
        this.prix_client=0;
    }

    public Article() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //setters
     public void setPrix_client(int p) {
        this.prix_client = p;
    }
     public void setQt_client(int p) {
        this.qt_client = p;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setMarque(String m){
        this.marque=m;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    
    public void setPrix_pack(int prix_pack) {
        this.prix_pack = prix_pack;
    }
   
      public void setQuantite_pack(int p) {
        this.quantite_pack = p;
    }
    
    public void setDescription(String name) {
        this.description = name;
    }
      
    //getters
    public int getPrix_client() {
        return prix_client;
    }
      public int getQt_client() {
        return qt_client;
    }
    public int getStock() {
        return stock;
    }

    public int getRef() {
        return ref;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }
    
    public int getPrix_pack() {
        return prix_pack;
    }

    public int getQuantite_pack(){
        return quantite_pack;
    }
    public String getDescription() {
        return description;
    }
    
    public String getMarque() {
        return marque;
    }

        @Override
    public String toString()
    {
        return "Produit: "+this.marque+"  "+this.description;
    }
}

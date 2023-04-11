/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author thoma
 */
public class Article {
    private String name;
    private String marque;
    private int ref;
    private int prix;
    private int stock;
    public Article(String n,String m, int r, int p, int s){
        name=n;
        marque=m;
        ref=r;
        prix=p;
        stock=s;
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

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public int getRef() {
        return ref;
    }

    public int getPrix() {
        return prix;
    }

    public String getName() {
        return name;
    }
    
    public String getMarque() {
        return marque;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

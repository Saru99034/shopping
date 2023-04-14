/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author thoma
 */
import java.util.ArrayList;

public class Panier {
   
    private ArrayList<Article> list_article = new ArrayList();
    private int prix;
    
    public ArrayList<Article> getArrayList() {
        return this.list_article;
    }


    public int getListSize() {
        return this.list_article.size();
    }


    public int getPrix(){ //retourne le prix total du panier
        return this.prix;
    }

    public void setPrix(int p)
    {
        this.prix=p;
    }
    public void setArrayList(ArrayList<Article> arrayList) {
        this.list_article = arrayList;
    }
    
    //....calcul prix total de mon panier....

   /* public Object Supprimer() {
        if (this.getListSize() == 0) {
            System.out.println("Erreur : La liste est vide");
            return null;
        } else {
            return this.arrayList.remove(this.position);
        }
    }*/

    //ajoute un article au panier
    public void Ajouter(Article obj) {
        this.list_article.add(obj);
    }
    
    
}
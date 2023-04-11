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
    private  ArrayList <Pair> listeArticle; // Liste d'article associé a son nombre
    private int prix;
    public Panier(){
        listeArticle=null;
        prix=0;
    }

    public void addArticle(Article a){
        
        for(int i=0;i<listeArticle.size();i++){
            if(listeArticle.get(i).first.getRef()==a.getRef()) {
                listeArticle.get(i).second++;
            }
            else listeArticle.add(new Pair(a));
            prix+=a.getPrix();
           
            //
        }
    }
    public void remove(Article a){
        for(int i=0;i<listeArticle.size();i++){
            if(listeArticle.get(i).first.getRef()==a.getRef()){
                if(listeArticle.get(i).second>1) listeArticle.get(i).second--;
                else listeArticle.remove(i);
                prix-=a.getPrix();
                //Ajouter 1 dans le stock de l'article
            }
        }
    }

    public  ArrayList<Pair> getListeArticle() {
        return listeArticle;
    }

    public int getPrix() {
        return prix;
    }
}

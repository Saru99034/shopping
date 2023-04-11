/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author thoma
 */
import java.util.Date;
import java.util.ArrayList;

public class Commande {
    private int numCom;
    private  ArrayList <Pair> ListeArticle;
    private int PrixTotal;
    private Date date;

    public Commande(Panier p){
        ListeArticle=p.getListeArticle();
        PrixTotal=p.getPrix();
        date.getTime();
    }
    
    int getPrix(){
        return PrixTotal;
    }
}

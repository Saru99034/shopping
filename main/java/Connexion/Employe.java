/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

import java.util.ArrayList;

/**
 *
 * @author 33768
 */
public class Employe extends Personne {
    
    private String employe_mdp=new String();
    private ArrayList<Client> listeClients=new ArrayList<Client>(); // la liste des clients

    
    public Employe(String nom,String prenom,int numero,String mail,int numero_voie,String adresse,String ville,String pays,String mdp){
        this.nom_personne=nom;
        this.prenom_personne=prenom;
        this.tel_personne=numero;
        this.mail_personne=mail;
        this.num_voie_personne=numero_voie;
        this.adresse_personne=adresse;
        this.ville_personne=ville;
        this.pays_personne=pays;
        this.employe_mdp=mdp;
          this.connexion_personne=false; //initialise à false= pas connecté
    }
    
    
    public String getMdpEmployee()
    {
        return this.employe_mdp;
    }
    
      @Override
    public String getNomPersonne() {
        
        return this.nom_personne;
    }

    @Override
    public String getPrenomPersonne() {
        
        return this.prenom_personne;
    }
    
      @Override
    public int getNumPersonne() {
        
        return this.tel_personne;
    }

    @Override
    public String getMailPersonne() {
        
        return this.mail_personne;
    }

    @Override
    public int getNumVoiePersonne() {
        return this.num_voie_personne;

    }
    
    
    @Override
    public String getAdressePersonne() {

        return this.adresse_personne;
    }

    @Override
    public String getVillePersonne() {
        return this.ville_personne;
    }

    @Override
    public String getPaysPersonne() {
        
        return this.pays_personne;
    }
    
    @Override
    public Boolean getConnexionPersonne() {
        
        return this.connexion_personne;
    }

     @Override
    public void setConnexionPersonne(Boolean p) {
        
        this.connexion_personne=p;
    }
    @Override
    public String toString() {
        
        return "Nous avons Employé "+this.nom_personne+" "+this.prenom_personne+" qui vit à l'adresse: "+this.num_voie_personne+" "+this.adresse_personne+", "+this.ville_personne+", "+this.pays_personne;
    }
   
    
}

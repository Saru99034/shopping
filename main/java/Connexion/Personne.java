/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author 33768
 */
import java.util.*;

public abstract class Personne {
    
    protected String nom_personne=new String();
    protected String prenom_personne=new String();
    protected int tel_personne;
    protected String mail_personne=new String();
    protected int num_voie_personne;
    protected String adresse_personne=new String();
    protected String ville_personne=new String();
    protected String pays_personne=new String();
    protected Boolean connexion_personne; //permet de savoir si la personne s'est bien connecté ou pas
    
    
    public abstract String getNomPersonne();
    public abstract String getPrenomPersonne();
    public abstract int getNumPersonne();
    public abstract String getMailPersonne();
    public abstract int getNumVoiePersonne();
    public abstract String getAdressePersonne();
    public abstract String getVillePersonne();
    public abstract String getPaysPersonne();
    public abstract Boolean getConnexionPersonne();
    public abstract void setConnexionPersonne(Boolean p);
    
    @Override
    public abstract String toString();
}

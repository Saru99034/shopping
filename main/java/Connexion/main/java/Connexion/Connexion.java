/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connexion;

/**
 *
 * @author 33768
 */

import java.sql.*;
import java.util.ArrayList;


public class Connexion {
    
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    public ArrayList<String> tables = new ArrayList<>();  //liste des tables de wampserveur
    public ArrayList<String> requetes = new ArrayList<>(); //liste de toutes les requêtes de sélection SQL
    public ArrayList<String> requetesMaj = new ArrayList<>();  //liste de toutes les requêtes de mise à jour SQL


    
    public Connexion(String nameDatabase, String loginDatabase,String passwordDatabase) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //nameDatabase="shopping";  //nom de la database sur wampserveur
        String urlDatabase="jdbc:mysql://localhost:3306/" + nameDatabase;
        
        //création d'une connexion JDBC à la base 
        conn=DriverManager.getConnection(urlDatabase,loginDatabase,passwordDatabase);
        
        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
        
    }
    
    
     /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }
    
     /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }
    
     /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }
    
    
    
    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
    
    
    
}

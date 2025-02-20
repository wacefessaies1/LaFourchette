/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Fournisseur;
import entities.Produit;
import entities.ProduitFournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author wacef
 */
public class FournisseurService {
    Connection cnx;
    public FournisseurService() {
         cnx = MyConnection.getInstance().getCnx();
    }
    public boolean ajouterFournisseur(Fournisseur t) {
        try {
            String query="INSERT INTO fournisseur(nomF,telephoneF,emailF,lvl) values(?,?,?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, t.getNomF());
            smt.setInt(2, t.getTelephoneF());
            smt.setString(3, t.getEmailF());
            smt.setInt(4, 0);
            smt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
       }
    }
    public boolean modifierFournisseur(Fournisseur t) {
        try {
            String query2="update fournisseur set  nomF=?, telephoneF=?, emailF=?, lvl=? where idF=?";
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, t.getNomF());
            smt.setInt(2, t.getTelephoneF());
            smt.setString(3, t.getEmailF());
            smt.setInt(4, t.getLvl());
            smt.setInt(5, t.getIdF());
            smt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean supprimerFournisseur(Fournisseur t) {
        try {
            String query2="delete from fournisseur where idF=?";
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setInt(1, t.getIdF());
            smt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public List<Fournisseur> afficherFournisseur(){
        ArrayList l=new ArrayList(); 
        try {
            String query2="SELECT * FROM fournisseur";
            PreparedStatement smt = cnx.prepareStatement(query2);
            Fournisseur f;
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
               f=new Fournisseur(rs.getInt("idF"),rs.getString("nomF"),rs.getInt("telephoneF"),rs.getString("emailF"));
               l.add(f);
            }
            System.out.println(l);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
    public List<Fournisseur> getListeFournisseur() {
        ArrayList l=new ArrayList(); 
        try {
            String query2="SELECT * FROM fournisseur f left join produit_fournisseur pf ON f.idF = pf.idF left JOIN produit p ON p.nomProd = pf.nomProd order BY f.idF";
            PreparedStatement smt = cnx.prepareStatement(query2);
            Fournisseur f;
            Produit p;
            ProduitFournisseur pf;
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
               f = new Fournisseur(rs.getInt("idF"),rs.getString("nomF"),rs.getInt("telephoneF"),rs.getString("emailF"),rs.getInt("lvl"));
               l.add(f);
               pf = new ProduitFournisseur(rs.getInt("id"),rs.getString("nomProd"),rs.getInt("idF"));
               l.add(pf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
    public List<Fournisseur> afficherListFournisseur(){
        List l = getListeFournisseur();
        List lf = new ArrayList();
        List lp = new ArrayList();
        for(int i=0 ; i<l.size() ; i++){
            if(l.get(i) instanceof Fournisseur){
                lf.add(l.get(i));
            }
            if(l.get(i) instanceof ProduitFournisseur){
                lp.add(l.get(i));
            }
        }
        List ll = new ArrayList();
        List listFinal = new ArrayList();
        for(int i=0 ; i<lf.size() ; i++){
            if(!verifFournisseur(ll, (Fournisseur) lf.get(i))){
                ll.add(lf.get(i));
                listFinal.add(lf.get(i));
            }
            listFinal.add(lp.get(i));
        }
        return listFinal;
    }
    private boolean verifFournisseur(List<Fournisseur> lf,Fournisseur f){
        for(int i=0 ; i<lf.size() ; i++){
            if(f.getIdF() == lf.get(i).getIdF()){
                return true;
            }
        }
        return false;
    }
    
}

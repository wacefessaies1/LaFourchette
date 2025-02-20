/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Plat;
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
public class PlatService {
    Connection cnx;
     public PlatService() {
         cnx = MyConnection.getInstance().getCnx();
    }
    public void ajouter(Plat t) {
        try {
           String query="INSERT INTO plat(designation,prix,description,imageP,nomProd) values(?,?,?,?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, t.getReference());
            smt.setString(2, t.getDesignation());
            smt.setDouble(3, t.getPrix());
            smt.setString(4, t.getDescription());
            smt.setString(5, t.getImageP());
            smt.setString(6, t.getNomProd());
            smt.executeUpdate();
            System.out.println("ajout avec succee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       }
    }
    public void modifier(Plat t) {
        try {
            String query2="update plat set designation=?, prix=?, deescription=?, imageP=?, nomProd=? where reference=?";
            PreparedStatement smt = cnx.prepareStatement(query2);
             smt.setString(1, t.getDesignation());
            smt.setDouble(2, t.getPrix());
            smt.setString(3, t.getDescription());
            smt.setString(4, t.getImageP());
            smt.setString(5, t.getNomProd());
            smt.setString(6, t.getReference());
            smt.executeUpdate();
            System.out.println("modification avec succee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimer(Plat t) {
        try {
            String query2="delete from plat where reference=?";
            PreparedStatement smt = cnx.prepareStatement(query2);
            smt.setString(1, t.getReference());
            smt.executeUpdate();
            System.out.println("suppression avec succee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    public List<Plat> find() {
        ArrayList l=new ArrayList(); 
        try {
            String query2="select * from plat";
            PreparedStatement smt = cnx.prepareStatement(query2);
            Plat p;
            ResultSet rs= smt.executeQuery();
            while(rs.next()){
               p=new Plat(rs.getString("reference"),rs.getString("designation"),rs.getDouble("prix"),rs.getString("description"),rs.getString("imageP"),rs.getString("nomProd"));
               l.add(p);
            }
            System.out.println(l);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }
}

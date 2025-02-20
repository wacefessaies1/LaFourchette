/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author wacef
 */
public class Fournisseur {
    
    private int idF;
    private String nomF;
    private int telephoneF;
    private String emailF;
    private int lvl;

    public Fournisseur(String nomF, int telephoneF, String emailF) {
        this.nomF = nomF;
        this.telephoneF = telephoneF;
        this.emailF = emailF;
    }
    public Fournisseur(int idF,String nomF, int telephoneF, String emailF) {
        this.idF = idF;
        this.nomF = nomF;
        this.telephoneF = telephoneF;
        this.emailF = emailF;
    }
    
    public Fournisseur( String nomF, int telephoneF, String emailF, int lvl) {
        this.nomF = nomF;
        this.telephoneF = telephoneF;
        this.emailF = emailF;
        this.lvl = lvl;
    }
    
    public Fournisseur(int idF, String nomF, int telephoneF, String emailF, int lvl) {
        this.idF = idF;
        this.nomF = nomF;
        this.telephoneF = telephoneF;
        this.emailF = emailF;
        this.lvl = lvl;
    }

    public Fournisseur() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public int getTelephoneF() {
        return telephoneF;
    }

    public void setTelephoneF(int telephoneF) {
        this.telephoneF = telephoneF;
    }

    public String getEmailF() {
        return emailF;
    }

    public void setEmailF(String emailF) {
        this.emailF = emailF;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "idF=" + idF + ", nomF=" + nomF + ", telephoneF=" + telephoneF + ", emailF=" + emailF + ", lvl=" + lvl + '}';
    }
    
}

package uf1.infobosccoma.appjob.Model;

import java.io.Serializable;

/**
 * Created by Gerard on 06/02/2015.
 */
public class Oferta implements Serializable {
    private String titol, dataNoticia, emailEmpresa,descripcio,categoria,tipusContracte,telefon;
    private int codi;
    public Oferta(){

    }
    public Oferta(String titol, String dataNoticia, String emailEmpresa, String descripcio, String categoria, String tipusContracte,String telefon) {
        this.titol = titol;
        this.dataNoticia = dataNoticia;
        this.emailEmpresa = emailEmpresa;
        this.descripcio = descripcio;
        this.categoria = categoria;
        this.tipusContracte = tipusContracte;
        this.telefon=telefon;
    }
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDataNoticia() {
        return dataNoticia;
    }

    public void setDataNoticia(String dataNoticia) {
        this.dataNoticia = dataNoticia;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipusContracte() {
        return tipusContracte;
    }

    public void setTipusContracte(String tipusContracte) {
        this.tipusContracte = tipusContracte;
    }

    @Override
    public String toString() {
        return  titol + "---" +categoria ;
    }
}

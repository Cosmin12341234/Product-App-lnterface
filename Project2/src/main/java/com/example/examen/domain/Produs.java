package com.example.examen.domain;

public class Produs extends Entity {

    private String marca;
    private String nume;
    private int pret;
    private int cantitate;

    public Produs(Integer id, String marca, String nume, int pret, int cantitate) {
        super(id);
        this.marca = marca;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return (this.id + "  " + this.marca + "  " + this.nume + "  " + this.pret + "  " + this.cantitate);
    }
}

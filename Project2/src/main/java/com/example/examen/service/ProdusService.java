package com.example.examen.service;

import com.example.examen.domain.Produs;
import com.example.examen.repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProdusService {
    IRepository<Produs> repoProdus;

    public ProdusService(IRepository<Produs> repoProdus) {
        this.repoProdus = repoProdus;
    }

    public void add(String marca, String nume, int pret, int cantitate) {
        Produs produs = new Produs(getNextId(), marca, nume, pret, cantitate);
        repoProdus.add(produs);
    }

    public int getNextId() {
        ArrayList<Produs> produse = repoProdus.getAll();
        if (produse.isEmpty())
            return 1;
        else {
            int maxId = produse.get(0).getId();
            for (Produs produs : produse) {
                if (produs.getId() > maxId)
                    maxId = produs.getId();
            }
            return maxId + 1;
        }
    }

    public List<Produs> getProduseOrdonate() {
        List<Produs> produse = repoProdus.getAll();
        produse.sort(Comparator.comparing(Produs::getId));
        return produse;
    }

    public List<Produs> filtreazaDupaNumeSauMarca(String text) {
        List<Produs> produse = getProduseOrdonate();
        List<Produs> produseFiltrate = new ArrayList<>();
        text = text.toLowerCase();
        for (Produs produs : produse) {
            String nume = produs.getNume().toLowerCase();
            String marca = produs.getMarca().toLowerCase();
            if (nume.contains(text) || marca.contains(text))
                produseFiltrate.add(produs);
        }
        return produseFiltrate;
    }

    public void populeazaLista()
    {
        Produs produs1 = new Produs(1, "eweqw", "dcsasdas", 1000, 7);
        Produs produs2 = new Produs(2, "ewqeqdsa", "dqdqw", 5, 4);
        Produs produs3 = new Produs(3, "wdqwqd", "dqwdqqwwd", 40, 313);
        Produs produs4 = new Produs(4, "dwqqwdqdw", "dasdadasd", 10, 11);
        Produs produs5 = new Produs(5, "dsadsa", "dsadads", 110, 1230);

        repoProdus.add(produs1);
        repoProdus.add(produs2);
        repoProdus.add(produs3);
        repoProdus.add(produs4);
        repoProdus.add(produs5);
    }
}

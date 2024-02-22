package com.example.examen;

import com.example.examen.domain.Produs;
import com.example.examen.service.ProdusService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class MyController {
    private ProdusService service;

    @FXML
    private TextField textFieldFiltrare;

    @FXML
    private ListView lista;

    @FXML
    private TextField textFieldMarca;

    @FXML
    private TextField textFieldNume;

    @FXML
    private TextField textFieldPret;

    @FXML
    private TextField textFieldCantitate;

    void setService(ProdusService service) {
        this.service = service;
        service.populeazaLista();
        init_list();
    }

    @FXML
    private void init_list() {
        lista.getItems().clear();

        List<Produs> produse = service.getProduseOrdonate();
        for (Produs produs : produse) {
            if (produs.getCantitate() == 0) {
                lista.getItems().add("Id: " + produs.getId() + " Marca: " + produs.getMarca() + " Nume: "
                        + produs.getNume() + " Pret: " + produs.getPret() + " Cantitate: n/a");
            } else {
                lista.getItems().add("Id: " + produs.getId() + " Marca: " + produs.getMarca() + " Nume: "
                        + produs.getNume() + " Pret: " + produs.getPret() + " Cantitate: " + produs.getCantitate());
            }
        }
    }


    @FXML
    private void filtreazaButtonOnClick() {
        lista.getItems().clear();

        String text = textFieldFiltrare.getText();
        List<Produs> produseFiltrate = service.filtreazaDupaNumeSauMarca(text);

        if (produseFiltrate.isEmpty()) {
            showAlert("Nu exista produse cu numele sau marca " + text);
            init_list();
        } else {
            for (Produs produs : produseFiltrate) {
                lista.getItems().add("Id: " + produs.getId() + " Marca: " + produs.getMarca() + " Nume: "
                        + produs.getNume() + " Pret: " + produs.getPret() + " Cantitate: " + produs.getCantitate());
            }
        }
    }

    @FXML
    private void adaugaButtonOnClick() {
        String marca = textFieldMarca.getText();
        String nume = textFieldNume.getText();
        int pret = Integer.parseInt(textFieldPret.getText());
        int cantitate = Integer.parseInt(textFieldCantitate.getText());
        service.add(marca, nume, pret, cantitate);

        textFieldMarca.clear();
        textFieldNume.clear();
        textFieldPret.clear();
        textFieldCantitate.clear();
        init_list();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

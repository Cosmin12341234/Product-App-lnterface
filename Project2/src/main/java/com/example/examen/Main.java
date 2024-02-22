package com.example.examen;

import com.example.examen.domain.Produs;
import com.example.examen.service.ProdusService;
import com.example.examen.repository.AbstractRepository;
import com.example.examen.repository.BinaryRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        java.util.Properties p = new java.util.Properties();

        p.load(new FileReader("config.properties"));

        String produs = p.getProperty("Entity1");

        AbstractRepository<Produs> repository = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();
        MyController controller = loader.getController();

        repository = new BinaryRepository<>(produs);

        ProdusService service = new ProdusService(repository);

        controller.setService(service);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

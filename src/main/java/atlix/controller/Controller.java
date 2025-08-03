package atlix.controller;

import atlix.model.enums.Cargo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Arrays;

public class Controller extends Application {

    private ChoiceBox<Cargo> cargo;
    private ChoiceBox<Pair<String, String>> cars;
    private ComboBox<String> cargoComboBox;

    @Override
    public void start(Stage primaryStage) {

        var label1 = new Label("COMBO BOX EXAMPLE");
        cargoComboBox = new ComboBox<>();
        cargoComboBox.setEditable(true);
        cargoComboBox.getItems().addAll(Arrays.toString(Cargo.values()));


        Button btn = new Button("ENVIAR");
        btn.setOnAction(e -> {
            run();
        });


        VBox hbox = new VBox(label1, cargoComboBox, btn);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefWidth(200);
        hbox.setPrefHeight(200);

        cargo = new ChoiceBox<>();


        primaryStage.setScene(new Scene(hbox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void run() {
        String cargo1 = cargoComboBox.getSelectionModel().getSelectedItem();
        System.out.println("Cargo seleccionado: " + cargo1);
    }

    /*
    *   var label1 = new Label("CHOICE BOX EXAMPLE");
        cargo = new ChoiceBox<>();
        cargo.getItems().addAll(Cargo.values());

        VBox hbox = new VBox(label1, cargo);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(hbox));
        primaryStage.show();
    *
    *
    * */

    public Stage initChoiceForAssents() {
        cars = new ChoiceBox<>();
        var car = new Pair<>("Mazda 3", "$600000");
        cars.getItems().add(new Pair<>("Platina", "$40000"));
        cars.getItems().add(car);
        cars.getItems().add(new Pair<>("Toyota", "$800000"));
        cars.getItems().add(new Pair<>("Nissan Getta", "$500000"));
        var label2 = new Label("CHOICE BOX EXAMPLE");

        VBox hbox = new VBox(label2, cars);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        Stage primaryStage = new Stage();

        primaryStage.setScene(new Scene(hbox));
        return primaryStage;
    }
}
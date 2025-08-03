package atlix.controller;

import atlix.model.enums.Car;
import atlix.util.ShowAlert;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.HashMap;

public class RandomController extends Application {

    private static final HashMap<Car, Integer> cars = new HashMap<>();

    private static void initMap() {
        cars.put(Car.MAZDA, 600000);
        cars.put(Car.JETTA, 700000);
        cars.put(Car.PLATINA, 500000);
        cars.put(Car.HONDA, 800000);
        cars.put(Car.NISSAN, 650000);
        cars.put(Car.BOCHO, 1500000);
    }

    public static void main(String[] args) {
        initMap();
        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) {
        var lbl = new Label("Bienvenido a mi tianguis de autos");
        var button = new javafx.scene.control.Button("Comprar");
        var ComboBox = new javafx.scene.control.ComboBox<Car>();
        ComboBox.getItems().addAll(cars.keySet());

        button.setOnAction(event -> {
            Car selectedCar = ComboBox.getValue();
            if (selectedCar == null) {
                ShowAlert.showAlert("Error", "Por favor, selecciona un auto para comprar.", "", "Error");
                return;
            }
            buyCar(selectedCar);
        });

        var root = new javafx.scene.layout.VBox(10, lbl, ComboBox, button);
        root.setAlignment(Pos.CENTER);
        var scene = new javafx.scene.Scene(root, 300, 200);
        primaryStage.setTitle("Tianguis de Autos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void buyCar(Car car) {
        if (cars.containsKey(car)) {
            int price = cars.get(car);
            System.out.println("Has comprado un " + car + " por $" + price);
        } else {
            System.out.println("El auto seleccionado no está disponible.");
        }
    }
}

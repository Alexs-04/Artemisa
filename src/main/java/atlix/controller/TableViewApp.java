package atlix.controller;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewApp extends Application {

    @Override @SuppressWarnings("unchecked")
    public void start(Stage stage) throws Exception {

        TableView<Item> tblItems = new TableView<>();
        tblItems.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tblItems, javafx.scene.layout.Priority.ALWAYS);

        TableColumn<Item, String> skuCol = new TableColumn<>("SKU");
        TableColumn<Item, String> nameCol = new TableColumn<>("Name");
        TableColumn<Item, String> descriptionCol = new TableColumn<>("Description");
        TableColumn<Item, Boolean> taxCol = new TableColumn<>("Tax");

        skuCol.setCellValueFactory(new PropertyValueFactory<>("sku"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        taxCol.setCellValueFactory(new PropertyValueFactory<>("tax"));

        tblItems.getColumns().addAll(skuCol, nameCol, descriptionCol, taxCol);

        tblItems.getItems().addAll(
                new Item("12A", "Chelita", "Es Corona xd", true),
                new Item("12B", "Sabritas", "Son receta crujiente", false),
                new Item("12C", "Galletas", "Son de chocolate", true)
        );


        Button btnTax = new Button("Tax");
        Button btnDelete = new Button("Delete");

        btnDelete.disableProperty().bind(
                tblItems.getSelectionModel().selectedItemProperty().isNull()
        );

        btnTax.disableProperty().bind(
                tblItems.getSelectionModel().selectedItemProperty().isNull().or(
                        Bindings.selectBoolean(
                                tblItems.getSelectionModel().selectedItemProperty(), "tax"
                        ).not()
                )
        );


        HBox btnBox = new HBox(btnDelete, btnTax);
        btnBox.setSpacing(10);

        VBox root = new VBox(tblItems, btnBox);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setPrefSize(600, 400);
        stage.setTitle("TableView Example");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static class Item {
        private String sku;
        private String name;
        private String description;
        private Boolean tax;

        public Item(String sku, String name, String description, boolean tax) {
            this.sku = sku;
            this.name = name;
            this.description = description;
            this.tax = tax;
        }

        public String getSku() {
            return sku;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Boolean isTax() {
            return tax;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

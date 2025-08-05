package atlix.controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilterListExample extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList(
                new Usuario("Juan", "juan@example.com", 1),
                new Usuario("Ana", "ana@example.com", 0),
                new Usuario("Carlos", "carlos@example.com", 1),
                new Usuario("Luis", "luis@example.com", 0)
        );

        FilteredList<Usuario> usuariosFiltrados = new FilteredList<>(usuarios, u -> true);

        TableView<Usuario> tblUsuarios = new TableView<>(usuariosFiltrados);

        TableColumn<Usuario, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Usuario, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblUsuarios.getColumns().addAll(nombreCol, emailCol);

        ComboBox<String> cbFiltro = new ComboBox<>();
        cbFiltro.getItems().addAll("Ver Todos", "Activos", "Inactivos");
        cbFiltro.setValue("Ver Todos");

        cbFiltro.setOnAction(event -> {
            String opcion = cbFiltro.getValue();
            usuariosFiltrados.setPredicate(usuario -> {
                return switch (opcion) {
                    case "Activos" -> usuario.getEstado() == 1;
                    case "Inactivos" -> usuario.getEstado() == 0;
                    default -> true; // Ver Todos
                };
            });
        });

        // Layout
        VBox root = new VBox(10, cbFiltro, tblUsuarios);
        root.setPadding(new Insets(10));
        root.setPrefSize(400, 300);

        stage.setScene(new Scene(root));
        stage.setTitle("Filtrar Usuarios (sin mostrar estado)");
        stage.show();
    }

    public static class Usuario {
        private final String nombre;
        private final String email;
        private final int estado; // 1: Activo, 0: Inactivo

        public Usuario(String nombre, String email, int estado) {
            this.nombre = nombre;
            this.email = email;
            this.estado = estado;
        }

        public String getNombre() { return nombre; }
        public String getEmail() { return email; }
        public int getEstado() { return estado; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


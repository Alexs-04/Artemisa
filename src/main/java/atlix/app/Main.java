package atlix.app;

import atlix.util.Paths;
import atlix.util.ShowAlert;
import atlix.util.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            WindowLoader.showWindow(Paths.MAIN_TEST, "Test", false);
        } catch (IOException e) {
            ShowAlert.showAlert("NO SE PUDO CARGAR LA VENTANA PRINCIPAL", "Error al cargar la ventana", "Error", "error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

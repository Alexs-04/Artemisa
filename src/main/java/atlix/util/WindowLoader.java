package atlix.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;

import java.io.IOException;

public final class WindowLoader {

    private WindowLoader() {
    }

    public static void showWindow(String fxmlPath, String title, boolean resizable) throws IOException {
        FXMLLoader loader = new FXMLLoader(WindowLoader.class.getResource(fxmlPath));
        var root = loader.load();
        var stage = new javafx.stage.Stage();
        stage.setTitle(title);
        stage.setScene(new javafx.scene.Scene((Parent) root));
        stage.setResizable(resizable);
        stage.getIcons().add(new Image("img/icon.png"));
        stage.show();
    }
}

package atlix.controller;

import atlix.util.Paths;
import atlix.util.WindowLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class MainTestController {
    @FXML
    public Button btnInit;
    @FXML
    public Label lblTitle;

    private boolean flag = false;

    @FXML
    public void initialize() {
/*        btnInit.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                lblTitle.setText("HAS PULSADO ENTER");
                try {
                    WindowLoader.showWindow(Paths.LOGIN, "Test", false);
                    Stage stage = (Stage) btnInit.getScene().getWindow();
                    Stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/


    }

    public void run() {
        if (flag) {
            lblTitle.setStyle("-fx-background-color: #3db2ff;");
        }else {
            lblTitle.setStyle("");
        }
        updateFlag();
    }

    private void updateFlag() {
        flag = !flag;
    }
}

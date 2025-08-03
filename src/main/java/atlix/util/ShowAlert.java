package atlix.util;

import javafx.scene.control.Alert;

public final class ShowAlert {

    private ShowAlert() {
    }

    public static void showAlert(String message, String title, String header, String type) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setTitle(title);
        alert.setAlertType(getType(type));
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static Alert.AlertType getType(String type) {
        return switch (type.toLowerCase()) {
            case "error" -> javafx.scene.control.Alert.AlertType.ERROR;
            case "warning" -> javafx.scene.control.Alert.AlertType.WARNING;
            case "information" -> javafx.scene.control.Alert.AlertType.INFORMATION;
            default -> javafx.scene.control.Alert.AlertType.NONE;
        };
    }
}

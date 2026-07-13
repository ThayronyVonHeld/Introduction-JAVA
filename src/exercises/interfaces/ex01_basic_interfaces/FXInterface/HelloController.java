package ex02_basic_interfaces.FXInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label label;

    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome JAVAFX!");
    }
}

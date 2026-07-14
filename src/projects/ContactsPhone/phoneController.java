package projects.ContactsPhone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class phoneController {

    @FXML private Pane paineadd;
    @FXML private TextField name;
    @FXML private TextField telefone;
    @FXML private ListView listctt;

    private ObservableList<String> ctt = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        paineadd.setVisible(false);

    }


    public void addContatos(){
        name.clear();
        telefone.clear();
        paineadd.setVisible(true);

    }

    public void atualizarcontatos() {

        ctt.add(String.format("%s - %s",
                name.getText(),
                telefone.getText()));

        listctt.setItems(ctt);

        paineadd.setVisible(false);
    }
}

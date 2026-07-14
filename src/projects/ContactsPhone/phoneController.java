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

    String nome = name.getText();
    String tel = telefone.getText();

    @FXML
    public void initialize() {
        paineadd.setVisible(false);
        listctt.setItems(ctt);
    }


    public void addContatos(){
        paineadd.setVisible(true);

    }

    public void atualizarcontatos() {

        ctt.add(String.format("%s - %s",
                name.getText(),
                telefone.getText()));

        name.clear();
        telefone.clear();

        paineadd.setVisible(false);
    }
}

package projects.ContactsPhone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage mainstage) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/projects/ContactsPhone/phone.fxml"));
      Parent root = loader.load();

      mainstage.setScene(new Scene (root, 1024,600));
      mainstage.setTitle("PhoneContacts");
      mainstage.setResizable(true);
      mainstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


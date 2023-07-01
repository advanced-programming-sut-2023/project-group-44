package view.ProfileMenu.ChangeSlogan;

import controller.SignUpMenuController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ProfileMenu.ProfileMenu;

import java.net.URL;

public class ChangeSloganMenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = ChangeSloganMenu.class.getResource("/fxml/ChangeSloganMenu.fxml");
        assert url != null;
        BorderPane borderPane = FXMLLoader.load(url);
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

}

package view.ProfileMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class ProfileMenuRun extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = ProfileMenuRun.class.getResource("/fxml/ProfileMenu.fxml");
        assert url != null;
        BorderPane borderPane = FXMLLoader.load(url);
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}

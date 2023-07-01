package view.ProfileMenu.ChangeEmail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.Main;
import view.ProfileMenu.ChangeNickname.ChangeNicknameMenu;

import java.net.URL;

public class ChangeEmailMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = ChangeEmailMenu.class.getResource("/fxml/ChangeEmailMenu.fxml");
        assert url != null;
        BorderPane borderPane = FXMLLoader.load(url);

        Image img = new Image(Main.class.getResource("/images/wallpaper.jpg").toExternalForm());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        borderPane.setBackground(bGround);

        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}

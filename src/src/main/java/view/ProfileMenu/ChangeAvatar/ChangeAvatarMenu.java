package view.ProfileMenu.ChangeAvatar;

import controller.ProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenu;

import java.io.File;
import java.net.URL;

public class ChangeAvatarMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = ChangeAvatarMenu.class.getResource("/fxml/ChangeAvatarMenu.fxml");
        assert url != null;
        BorderPane borderPane = FXMLLoader.load(url);

        Image img = new Image(Main.class.getResource("/images/wallpaper.jpg").toExternalForm());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background bGround = new Background(bImg);

        Button button = new Button("Select another avatar");
        button.setOnAction(value ->  {
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Search Image");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Search image", "*.png", "*.jpg"));
                File selectedFile = fileChooser.showOpenDialog(stage);

                if (selectedFile != null) {
                    Image image=new Image(getClass().getResource(selectedFile.toString()).toString());
                    ProfileMenuController.addImageToProfile(image);
                }
            } catch (Exception e) {
                System.out.println("You must handle the error: " + e.getMessage());
            }
        });
        borderPane.setLeft(button);

        borderPane.setBackground(bGround);
        Scene scene=new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}

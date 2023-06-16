package view;

import controller.SignUpMenuController;
import controller.dataBaseJSON;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.SignUpMenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application {
    public Label usernameLabel;
    public Label passwordLabel;
    public Label emailLabel;
    public TextField username;
    public PasswordField password;
    public TextField email;
    public Tooltip toolTip = new Tooltip();
    public boolean hidePassword = true;
    public static Stage stage;

    public static void main(String[] args) throws IOException {

        //File file = new File("usersData.json");
        //file.createNewFile();
        //File file1 = new File("map.json");
        //file1.createNewFile();
        //dataBaseJSON.initializeUsers();
        //dataBaseJSON.initializeMap();

        launch();
        //Scanner scanner = new Scanner(System.in);
        //SignUpMenu signUpMenu = new SignUpMenu();
        //signUpMenu.run(scanner);

        //dataBaseJSON.emptyMapJSOn();
        //dataBaseJSON.saveUsersInJSON();
        //dataBaseJSON.saveMapInJSON();

    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        BorderPane pane = FXMLLoader.load(
                new URL(Main.class.getResource("/fxml/SignUpMenu.fxml").toExternalForm()));

        //toolTip = new Tooltip();
        toolTip.setShowDelay(Duration.ZERO);
        toolTip.setAutoHide(false);
        toolTip.setMinWidth(50);

        Image img = new Image(Main.class.getResource("/images/wallpaper.jpg").toExternalForm());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        pane.setBackground(bGround);


        Scene scene = new Scene(pane);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        username.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.usernameValidationFx(newText))
                usernameLabel.setText("*valid username format");
            else usernameLabel.setText("*Invalid username format");
        });
        password.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.passwordValidationFx(newText))
                passwordLabel.setText("*valid password format");
            else passwordLabel.setText("*Invalid password format");
            if (!hidePassword) toolTip.setText(newText);
        });
        email.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.emailValidationFx(newText))
                emailLabel.setText("*valid email format");
            else emailLabel.setText("*Invalid email format");
        });
    }

    public void showPassword(MouseEvent mouseEvent) {
        if (hidePassword) {
            Point2D p = password.localToScene(password.getBoundsInLocal().getMaxX(), password.getBoundsInLocal().getMaxY());
            toolTip.setText(password.getText());
            toolTip.show(password,
                    p.getX() + stage.getScene().getX() + stage.getX(),
                    p.getY() + stage.getScene().getY() + stage.getY());
            hidePassword = false;
        } else {
            toolTip.setText("");
            toolTip.hide();
            hidePassword = true;
        }
    }

    public void randomPassword(MouseEvent mouseEvent) {
        String randomPassword = SignUpMenuController.randomPasswordFx();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Random password is : " + randomPassword, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            password.setText(randomPassword);
        }
    }

    public void slogan(MouseEvent mouseEvent) {
        TextField slogan = new TextField("slogan");

    }
}


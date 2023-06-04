package view;

import controller.SignUpMenuController;
import controller.dataBaseJSON;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.SignUpMenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application{
    public Label usernameLabel;
    public Label passwordLabel;
    public TextField username;
    public PasswordField password;
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

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        username.textProperty().addListener((observable, oldText, newText)->{
            if(SignUpMenuController.usernameValidationFx(newText))
                usernameLabel.setText("*valid username format");
            else usernameLabel.setText("*Invalid username format");
        });
        password.textProperty().addListener((observable, oldText, newText)->{
            if(SignUpMenuController.passwordValidationFx(newText))
                passwordLabel.setText("*valid password format");
            else passwordLabel.setText("*Invalid password format");
        });
    }
}


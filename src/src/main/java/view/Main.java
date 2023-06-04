package view;

import controller.dataBaseJSON;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.SignUpMenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main extends Application{
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
}


package view;

import controller.SignUpMenuController;
import controller.dataBaseJSON;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.SignUpMenu;
import java.io.File;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;

public class Main extends Application {
    /* ________________________________________ GRAPHICS ________________________________________ */
    @FXML
    private Label MainLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField nickname;
    @FXML
    private TextField sloganBox;
    @FXML
    private CheckBox randomSloganCheckBox;
    @FXML
    private ComboBox<String> popularSlogansComboBox;
    @FXML
    private Button RegisterButton;
    public Tooltip toolTip = new Tooltip();
    public boolean hidePassword = true;
    public static Stage stage;
    private Popup popup = new Popup();
    private Label pLabel = new Label();
    private boolean problem1, problem2, problem3, problem4, problem5 = false; // false is OK


    // .:: START ::.
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

    // .:: INITIALIZE ::.
    @FXML
    public void initialize() {
        popularSlogansComboBox.setItems(FXCollections.observableArrayList("Peace Through Strength.", "Ready for All, Yielding to None.", "Molon Labe"));
        sloganBox.setVisible(false);
        randomSloganCheckBox.setVisible(false);
        popularSlogansComboBox.setVisible(false);
        // username
        username.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.usernameValidationFx(newText)) {
                usernameLabel.setText("*Valid username format*");
                username.getStyleClass().removeAll("errorField", "acceptedField");
                username.getStyleClass().add("acceptedField");
                problem1 = false;
            } else if (newText.equals("")) {
                username.getStyleClass().removeAll("errorField", "acceptedField");
                problem1 = true;
            } else {
                usernameLabel.setText("*Invalid username format*");
                username.getStyleClass().removeAll("errorField", "acceptedField");
                username.getStyleClass().add("errorField");
                problem1 = true;
            }
        });

        // password
        password.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.passwordValidationFx(newText)) {
                passwordLabel.setText("*Valid password format*");
                password.getStyleClass().removeAll("errorField", "acceptedField");
                password.getStyleClass().add("acceptedField");
                problem2 = false;
            } else if (newText.equals("")) {
                password.getStyleClass().removeAll("errorField", "acceptedField");
                problem2 = true;
            } else {
                passwordLabel.setText("*Invalid password format*");
                password.getStyleClass().removeAll("errorField", "acceptedField");
                password.getStyleClass().add("errorField");
                problem2 = true;
            }
            if (!hidePassword) toolTip.setText(newText);
        });

        // email
        email.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.emailValidationFx(newText)) {
                emailLabel.setText("*Valid email format*");
                email.getStyleClass().removeAll("errorField", "acceptedField");
                email.getStyleClass().add("acceptedField");
                problem3 = false;
            } else if (newText.equals("")) {
                email.getStyleClass().removeAll("errorField", "acceptedField");
                problem3 = true;
            } else {
                emailLabel.setText("*Invalid email format*");
                email.getStyleClass().removeAll("errorField", "acceptedField");
                email.getStyleClass().add("errorField");
                problem3 = true;
            }
        });

        // nickname
        nickname.textProperty().addListener((observable, oldText, newText) -> {
            if (!newText.equals("")) {
                nickname.getStyleClass().removeAll("errorField", "acceptedField");
                nickname.getStyleClass().add("acceptedField");
                problem4 = false;
            } else {
                nickname.getStyleClass().removeAll("errorField", "acceptedField");
                problem3 = true;
            }
        });

        // slogan
        sloganBox.textProperty().addListener((observable, oldText, newText) -> {
            if (!newText.equals("")) {
                sloganBox.getStyleClass().removeAll("errorField", "acceptedField");
                sloganBox.getStyleClass().add("acceptedField");
            } else {
                sloganBox.getStyleClass().removeAll("errorField", "acceptedField");
            }
        });

        // slogan comboBox
        popularSlogansComboBox.setOnAction(e -> {
            String selected = popularSlogansComboBox.getSelectionModel().getSelectedItem();
            sloganBox.setText(selected);
        });
        randomSloganCheckBox.setOnAction(e -> {
            sloganBox.setText(SignUpMenuController.generateSlogan());
        });

//        MainLabel.setVisible(false);
//        MainLabel.setVisible(true);

        pLabel.setText("Successful SignUp!");
        pLabel.setMinWidth(300);
        pLabel.setMinWidth(130);
        pLabel.setStyle("-fx-background-color: #08f080; -fx-font-color: #075238; -fx-font-size: 25; -fx-font-weight: bold");
        pLabel.setPadding(new Insets(20));
        popup.getContent().add(pLabel);
        popup.setAutoHide(true);
    }


    // .:: ACTION EVENT METHODS ::.
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
        sloganBox.setVisible(!sloganBox.isVisible());
        randomSloganCheckBox.setVisible(!randomSloganCheckBox.isVisible());
        popularSlogansComboBox.setVisible(!popularSlogansComboBox.isVisible());

    }

    public void onAlreadyHaveClick(MouseEvent mouseEvent) throws Exception {
        new LoginMenu().start(Main.stage);
    }

    public void onRegisterButtonClick(ActionEvent event) {
        if (username.getText().isEmpty()) {
            username.getStyleClass().removeAll("errorField", "acceptedField");
            username.getStyleClass().add("errorField");

        }
        if (password.getText().isEmpty()) {
            password.getStyleClass().removeAll("errorField", "acceptedField");
            password.getStyleClass().add("errorField");
        }
        if (email.getText().isEmpty()) {
            email.getStyleClass().removeAll("errorField", "acceptedField");
            email.getStyleClass().add("errorField");
        }
        if (nickname.getText().isEmpty()) {
            nickname.getStyleClass().removeAll("errorField", "acceptedField");
            nickname.getStyleClass().add("errorField");
        }
        if (sloganBox.isVisible()) {
            if (sloganBox.getText().isEmpty()) {
                sloganBox.getStyleClass().removeAll("errorField", "acceptedField");
                sloganBox.getStyleClass().add("errorField");
                problem5 = true;
            } else problem5 = false;
        }
        if (!sloganBox.isVisible()) problem5 = false;

        if (problem5 == false && problem4 == false && problem3 == false && problem2 == false && problem1 == false) {
            String aUsername = username.getText();
            String aPassword = password.getText();
            String aNickname = nickname.getText();
            String anEmail = email.getText();
            if (sloganBox.isVisible())
                MainLabel.setText(SignUpMenuController.createUser(aUsername, aPassword, aNickname, anEmail, null));
            else
                MainLabel.setText(SignUpMenuController.createUser(aUsername, aPassword, aNickname, anEmail, sloganBox.getText()));
            popup.show(stage);
        }
    }

    /* __________________________________________________________________________________________ */

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
}



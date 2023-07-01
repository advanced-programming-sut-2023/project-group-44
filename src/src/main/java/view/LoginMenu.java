package view;

import controller.LoginMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.App;
import model.User;
import view.MainMenu.MainMenu;
import view.MainMenu.MainMenuRun;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.*;


public class LoginMenu extends Application {


    /* ________________________________________ GRAPHICS ________________________________________ */
    @FXML
    private Label text1;
    @FXML
    private Label text2;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button logInButton;
    @FXML
    private Label forgotPassword;
    @FXML
    private Button back;
    @FXML
    private Label loginStatus;
    @FXML
    private PasswordField answerBox;
    @FXML
    private PasswordField newPass;
    @FXML
    private PasswordField confirmNewPass;
    @FXML
    private Label forgotPassLabel;
    @FXML
    private ImageView OKButton1;
    @FXML
    private ImageView OKButton2;
    public static boolean captchaVerification = false;
    private Captcha captcha = new Captcha();


    // .:: START ::.
    @Override
    public void start(Stage stage) throws Exception {
        URL url = LoginMenu.class.getResource("/fxml/LogInMenuFXML.fxml");
        Pane root = FXMLLoader.load(url);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 1200, 800);
        Image img = new Image(Main.class.getResource("/images/wallpaper.jpg").toExternalForm());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // .:: INITIALIZE ::.
    @FXML
    public void initialize(){
        answerBox.setVisible(false);
        newPass.setVisible(false);
        confirmNewPass.setVisible(false);
        OKButton1.setVisible(false);
        OKButton2.setVisible(false);
        forgotPassLabel.setVisible(false);
    }


    // .:: ACTION EVENT METHODS ::.
    public void onLogInButtonClick(ActionEvent event) throws Exception {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();
        App.setCurrentUser(App.getUserByUsername(enteredUsername));
        switch (LoginMenuController.checkCredentials(enteredUsername, enteredPassword)) {
            case 1:
                captcha.start(Captcha.captchaStage);
                if (captchaVerification == true) {
                    App.setCurrentUser(App.getUserByUsername(enteredUsername));
                    new MainMenuRun().start(Main.stage);
                }

                else{
                    loginStatus.setText("You Might Not Be A Human!");
                }
                break;
            case 2:
                loginStatus.setText("Wrong Password!");
                break;
            case 3:
                loginStatus.setText("Username not found!");
                break;
        }
    }

    public void onBackButtonClicked(ActionEvent event) throws Exception {
        new Main().start(Main.stage);
    }

    public void onForgotPassClick (MouseEvent event) throws Exception {
        forgotPassword.setText("Security Question");
        answerBox.setVisible(!answerBox.isVisible());
        OKButton1.setVisible(!OKButton1.isVisible());
    }

    public void onFirstOKClick (MouseEvent event) throws Exception {
        // There might be a bug: changing the username after answering the security question :(
        String UserName = username.getText();
        String answer = answerBox.getText();
        switch (LoginMenuController.forgotPassFirstStep(UserName, answer)) {
            case 1:
                answerBox.setVisible(false);
                OKButton1.setVisible(false);
                newPass.setVisible(true);
                confirmNewPass.setVisible(true);
                OKButton2.setVisible(true);
                break;
            case 2:
                forgotPassLabel.setText("Incorrect Answer!");
                break;
            case 3:
                forgotPassLabel.setText("User Not Found!");
        }
    }

    public void onSecondOKClick (MouseEvent event) throws Exception {
        String UserName = username.getText();
        User user = App.getUserByUsername(UserName);
        String NewPass = newPass.getText();
        String ConfirmNewPass = confirmNewPass.getText();
        String result = LoginMenuController.forgotPassSecondStep(user, NewPass, ConfirmNewPass);
        forgotPassLabel.setText(result);
        Thread.sleep(3000);
        if (result.equals("Password Changed Successfully!")) {
            forgotPassword.setText("Forgot your password?");
            answerBox.setVisible(false);
            newPass.setVisible(false);
            confirmNewPass.setVisible(false);
            OKButton1.setVisible(false);
            OKButton2.setVisible(false);
        }
    }



    /* __________________________________________________________________________________________ */


    boolean flagLoggedIn = false;

    public void run(Scanner scanner) {

        Matcher matcher;
        String command;
        String regexNotStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+))$";
        String regexStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+)) \\-\\-stay\\-logged\\-in$";
        String regexForgotPass = "^forgot my password -u \"?([^\"]*)\"?$";
        while (true) {
                System.out.println("entered login menu");

                command = scanner.nextLine();

                // .::           Login Commands           ::.

                // Not Staying Logged In
                if ((matcher = LoginMenuController.getMatcher(command, regexNotStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    if (LoginMenuController.loginWithRetry(username, password, scanner)) {
                        App.setCurrentUser(App.getUserByUsername(matcher.group(1)));
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.run(scanner);
                        return;
                    }
                }

                // Staying Logged in
                else if ((matcher = LoginMenuController.getMatcher(command, regexStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    if (LoginMenuController.loginWithRetry(username, password, scanner)) {
                        App.setCurrentUser(App.getUserByUsername(matcher.group(1)));
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.run(scanner);
                        return;
                    }
                    flagLoggedIn = true;
                }

                // Forgot Password
                else if ((matcher = LoginMenuController.getMatcher(command, regexForgotPass)) != null) {
                    String username = matcher.group(1);
                    LoginMenuController.forgotPass(username, scanner);
                }

                // Invalid Command
                else if((matcher = LoginMenuController.getMatcher(command,"^exit$")) != null){
                    return;
                }else System.out.println("Invalid command");

        }
    }



}

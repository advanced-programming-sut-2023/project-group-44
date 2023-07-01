package view.ProfileMenu.ChangeUsername;

import controller.SignUpMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenu;
import view.ProfileMenu.ProfileMenuRun;

import static view.Main.stage;

public class ChangeUsernameMenuController {
    public Label result;
    public TextField username;
    public Label result2;
    private boolean problem1=true;
    public void initialize(){
        username.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.usernameValidationFx(newText)) {
                result.setText("*Valid username format*");
                username.getStyleClass().removeAll("errorField", "acceptedField");
                username.getStyleClass().add("acceptedField");
                problem1=false;
            } else if (newText.equals("")) {
                username.getStyleClass().removeAll("errorField", "acceptedField");
                problem1=true;
            } else {
                result.setText("*Invalid username format*");
                username.getStyleClass().removeAll("errorField", "acceptedField");
                username.getStyleClass().add("errorField");
                problem1=true;
            }
        });
    }
    public void submit(MouseEvent mouseEvent) {
        if (username.getText().isEmpty()) {
            username.getStyleClass().removeAll("errorField", "acceptedField");
            username.getStyleClass().add("errorField");
        }

        if (!problem1) {
            if(App.getUserByUsername(username.getText())==null) {
                result2.setText("successfully changed!");
                result2.setTextFill(Paint.valueOf("#16ae46"));
                App.getCurrentUser().setUsername(username.getText());
            }
            else {
                result2.setText("username is valid!");
                result2.setTextFill(Paint.valueOf("Red"));
            }
        }
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(stage);
    }
}

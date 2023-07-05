package view.ProfileMenu.ChangePassword;

import controller.SignUpMenuController;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class ChangePasswordMenuController {
    public PasswordField currentPassword;
    public PasswordField newPassword;
    public Label result1;
    public Label result2;
    public Label finalResult;
    public CheckBox checkBox1;
    public CheckBox checkBox2;
    public boolean problem1=true;
    public boolean problem2=true;
    public boolean hidePassword1=true;
    public boolean hidePassword2=true;
    public void initialize(){
        currentPassword.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.passwordValidationFx(newText)) {
                result1.setText("*Valid password format*");
                currentPassword.getStyleClass().removeAll("errorField", "acceptedField");
                currentPassword.getStyleClass().add("acceptedField");
                problem1 = false;
            } else if (newText.equals("")) {
                currentPassword.getStyleClass().removeAll("errorField", "acceptedField");
                problem1 = true;
            } else {
                result1.setText("*Invalid password format*");
                currentPassword.getStyleClass().removeAll("errorField", "acceptedField");
                currentPassword.getStyleClass().add("errorField");
                problem1 = true;
            }
        });

        newPassword.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.passwordValidationFx(newText)) {
                result2.setText("*Valid password format*");
                newPassword.getStyleClass().removeAll("errorField", "acceptedField");
                newPassword.getStyleClass().add("acceptedField");
                problem2 = false;
            } else if (newText.equals("")) {
                newPassword.getStyleClass().removeAll("errorField", "acceptedField");
                problem2 = true;
            } else {
                result2.setText("*Invalid password format*");
                newPassword.getStyleClass().removeAll("errorField", "acceptedField");
                newPassword.getStyleClass().add("errorField");
                problem2 = true;
            }
        });

    }
    public void submit(MouseEvent mouseEvent) {
        if (currentPassword.getText().isEmpty()) {
            currentPassword.getStyleClass().removeAll("errorField", "acceptedField");
            currentPassword.getStyleClass().add("errorField");
        }
        if (newPassword.getText().isEmpty()) {
            newPassword.getStyleClass().removeAll("errorField", "acceptedField");
            newPassword.getStyleClass().add("errorField");
        }
        if(!problem1 && !problem2){
            if(!currentPassword.getText().equals(App.getCurrentUser().getPassword())){
                finalResult.setText("Incorrect Password!");
                finalResult.setTextFill(Paint.valueOf("Red"));
            }
            else {
                finalResult.setText("Successfully changed!");
                finalResult.setTextFill(Paint.valueOf("#16ae46"));
                App.getCurrentUser().setPassword(newPassword.getText());
            }
        }
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }

    public void checkBox1(MouseEvent mouseEvent) {
        if(checkBox1.isSelected()) hidePassword1=true;
        else hidePassword1=false;
    }

    public void checkBox2(MouseEvent mouseEvent) {
        if(checkBox2.isSelected()) hidePassword2=true;
        else hidePassword2=false;
    }
}

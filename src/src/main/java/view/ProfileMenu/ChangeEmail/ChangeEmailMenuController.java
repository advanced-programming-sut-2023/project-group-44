package view.ProfileMenu.ChangeEmail;

import controller.SignUpMenuController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class ChangeEmailMenuController {
    public TextField email;
    public Label result1;
    public Label result2;
    public boolean problem1;
    public void initialize(){
        email.textProperty().addListener((observable, oldText, newText) -> {
            if (SignUpMenuController.emailValidationFx(newText)) {
                result1.setText("*Valid email format*");
                email.getStyleClass().removeAll("errorField", "acceptedField");
                email.getStyleClass().add("acceptedField");
                problem1 = false;
            } else if (newText.equals("")) {
                email.getStyleClass().removeAll("errorField", "acceptedField");
                problem1 = true;
            } else {
                result1.setText("*Invalid email format*");
                email.getStyleClass().removeAll("errorField", "acceptedField");
                email.getStyleClass().add("errorField");
                problem1 = true;
            }
        });
    }
    public void submit(MouseEvent mouseEvent) {
        if (email.getText().isEmpty()) {
            email.getStyleClass().removeAll("errorField", "acceptedField");
            email.getStyleClass().add("errorField");
        }
        if(!problem1){
            result2.setText("Successfully changed!");
            App.getCurrentUser().setEmail(email.getText());
        }
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }
}

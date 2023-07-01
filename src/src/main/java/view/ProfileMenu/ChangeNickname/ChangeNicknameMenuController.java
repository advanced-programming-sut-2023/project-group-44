package view.ProfileMenu.ChangeNickname;

import controller.SignUpMenuController;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class ChangeNicknameMenuController {
    public TextField nickname;
    public Label result1;
    public Label result2;
    public boolean problem1=true;

    public void initialize(){
        nickname.textProperty().addListener((observable, oldText, newText) -> {
            if (!newText.equals("")) {
                nickname.getStyleClass().removeAll("errorField", "acceptedField");
                nickname.getStyleClass().add("acceptedField");
                problem1 = false;
            } else {
                nickname.getStyleClass().removeAll("errorField", "acceptedField");
                problem1 = true;
            }
        });
    }
    public void submit(MouseEvent mouseEvent) {
        if (nickname.getText().isEmpty()) {
            nickname.getStyleClass().removeAll("errorField", "acceptedField");
            nickname.getStyleClass().add("errorField");
        }
        if(!problem1){
            result2.setText("Successfully changed!");
            App.getCurrentUser().setNickname(nickname.getText());
        }
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }
}

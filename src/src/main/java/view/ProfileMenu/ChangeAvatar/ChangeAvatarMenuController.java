package view.ProfileMenu.ChangeAvatar;

import controller.ProfileMenuController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class ChangeAvatarMenuController {
    public CheckBox one;
    public CheckBox two;
    public CheckBox three;
    public CheckBox four;
    public Label result;
    public void submit(ActionEvent actionEvent) {
        Image image;
        if(one.isSelected()){
            image=new Image(getClass().getResource("/images/image1.png").toString());
            ProfileMenuController.addImageToProfile(image);
            result.setText("successfully changed!");
        }
        else if(two.isSelected()){
            image=new Image(getClass().getResource("/images/image2.png").toString());
            ProfileMenuController.addImageToProfile(image);
            result.setText("successfully changed!");
        }
        else if(three.isSelected()){
            image=new Image(getClass().getResource("/images/image3.png").toString());
            ProfileMenuController.addImageToProfile(image);
            result.setText("successfully changed!");
        }
        else if(four.isSelected()){
            image=new Image(getClass().getResource("/images/image4.png").toString());
            ProfileMenuController.addImageToProfile(image);
            result.setText("successfully changed!");
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Changing Avatar Error");
            alert.setContentText("You haven't chosen any avatar!");
            alert.show();
        }
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }
}

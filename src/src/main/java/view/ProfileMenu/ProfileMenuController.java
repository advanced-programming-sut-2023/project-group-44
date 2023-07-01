package view.ProfileMenu;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.App;
import view.Main;
import view.ProfileMenu.ChangeAvatar.ChangeAvatarMenu;
import view.ProfileMenu.ChangeEmail.ChangeEmailMenu;
import view.ProfileMenu.ChangeNickname.ChangeNicknameMenu;
import view.ProfileMenu.ChangePassword.ChangePasswordMenu;
import view.ProfileMenu.ChangeSlogan.ChangeSloganMenu;
import view.ProfileMenu.ChangeUsername.ChangeUsernameMenu;

public class ProfileMenuController {

    public Label username;
    public Label password;
    public Label nickname;
    public Label email;
    public Label slogan;
    public ImageView imageView;

    public void updateLabels(){
        username.setText(App.getCurrentUser().getUsername());
        password.setText(App.getCurrentUser().getPassword());
        nickname.setText(App.getCurrentUser().getNickname());
        email.setText(App.getCurrentUser().getEmail());
        if(App.getCurrentUser().getSlogan()!=null)
            slogan.setText(App.getCurrentUser().getSlogan());
        else slogan.setText("You haven't chosen slogan yet!");
    }
    public void changeUsername(MouseEvent mouseEvent) throws Exception {
        new ChangeUsernameMenu().start(Main.stage);
    }

    public void changePassword(MouseEvent mouseEvent) throws Exception {
        new ChangePasswordMenu().start(Main.stage);
    }

    public void changeNickname(MouseEvent mouseEvent) throws Exception {
        new ChangeNicknameMenu().start(Main.stage);
    }

    public void changeEmail(MouseEvent mouseEvent) throws Exception {
        new ChangeEmailMenu().start(Main.stage);
    }

    public void changeAvatar(MouseEvent mouseEvent) throws Exception {
        new ChangeAvatarMenu().start(Main.stage);
    }

    public void Back(MouseEvent mouseEvent) {
        //new MainMenu().start(Main.stage);
    }

    public void initialize(){
        updateLabels();
        Image image=App.getCurrentUser().getProfileImage();
        imageView.setImage(image);
    }

    public void changeSlogan(MouseEvent mouseEvent) throws Exception {
        new ChangeSloganMenu().start(Main.stage);
    }
}

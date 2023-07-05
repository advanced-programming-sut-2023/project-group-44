module Project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;


    exports view;
    opens view to javafx.fxml;
    exports view.ProfileMenu;
    opens view.ProfileMenu to javafx.fxml;
    exports view.ProfileMenu.ChangeUsername;
    opens view.ProfileMenu.ChangeUsername to javafx.fxml;
    exports view.ProfileMenu.ChangePassword;
    opens view.ProfileMenu.ChangePassword to javafx.fxml;
    exports view.ProfileMenu.ChangeSlogan;
    opens view.ProfileMenu.ChangeSlogan to javafx.fxml;
    exports view.ProfileMenu.ChangeNickname;
    opens view.ProfileMenu.ChangeNickname to javafx.fxml;
    exports view.ProfileMenu.ChangeAvatar;
    opens view.ProfileMenu.ChangeAvatar to javafx.fxml;
    exports view.MainMenu;
    opens view.MainMenu to javafx.fxml;
    exports view.ProfileMenu.ChangeEmail;
    opens view.ProfileMenu.ChangeEmail to javafx.fxml;
    exports view.ProfileMenu.ScoreTable;
    opens view.ProfileMenu.ScoreTable to javafx.fxml;
}
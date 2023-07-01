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
    exports view.ProfileMenu.ChangeNickname;
    opens view.ProfileMenu.ChangeNickname to javafx.fxml;
}
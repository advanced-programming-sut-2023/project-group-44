package view.MainMenu;

import javafx.scene.input.MouseEvent;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class MainMenuController {
    public void EnterGame(MouseEvent mouseEvent) {

    }

    public void ProfileMenu(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }

    public void exit(MouseEvent mouseEvent) {
        System.exit(0);
    }
}

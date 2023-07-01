package view.ProfileMenu.ChangeSlogan;

import controller.SignUpMenuController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import model.App;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

public class ChangeSloganMenuController {

    public TextField sloganBox;
    public Label finalResult;

    public CheckBox randomSloganCheckBox;

    public ComboBox<String> popularSlogansComboBox;

    @FXML
    public void initialize() {
        popularSlogansComboBox.setItems(FXCollections.observableArrayList("Peace Through Strength.", "Ready for All, Yielding to None.", "Molon Labe"));

        sloganBox.textProperty().addListener((observable, oldText, newText) -> {
            if (!newText.equals("")) {
                sloganBox.getStyleClass().removeAll("errorField", "acceptedField");
                sloganBox.getStyleClass().add("acceptedField");
            } else {
                sloganBox.getStyleClass().removeAll("errorField", "acceptedField");
            }
        });

        // slogan comboBox
        popularSlogansComboBox.setOnAction(e -> {
            String selected = popularSlogansComboBox.getSelectionModel().getSelectedItem();
            sloganBox.setText(selected);
        });
        randomSloganCheckBox.setOnAction(e -> {
            sloganBox.setText(SignUpMenuController.generateSlogan());
        });
    }

    public void changeSlogan(MouseEvent mouseEvent) {
        finalResult.setText("Successfully changed!");
        finalResult.setTextFill(Paint.valueOf("#16ae46"));
        App.getCurrentUser().setSlogan(sloganBox.getText());

    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }
}

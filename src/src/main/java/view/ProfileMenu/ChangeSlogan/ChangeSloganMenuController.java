package view.ProfileMenu.ChangeSlogan;

import controller.SignUpMenuController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ChangeSloganMenuController {
    @FXML
    private TextField sloganBox;
    @FXML
    private CheckBox randomSloganCheckBox;
    @FXML
    private ComboBox<String> popularSlogansComboBox;

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
}

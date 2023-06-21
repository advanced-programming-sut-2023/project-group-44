package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lola extends Application {
    private TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the button
        Button button = new Button("Toggle Visibility");
        button.setOnAction(event -> toggleTextFieldVisibility());

        // Create the textfield
        textField = new TextField();
        textField.setPromptText("Enter text");

        // Create the layout
        VBox root = new VBox(10);
        root.getChildren().addAll(button, textField);

        // Create the scene
        Scene scene = new Scene(root, 300, 200);

        // Set the scene on the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("TextField Visibility Example");
        primaryStage.show();
    }

    private void toggleTextFieldVisibility() {
        textField.setVisible(!textField.isVisible());
    }
}

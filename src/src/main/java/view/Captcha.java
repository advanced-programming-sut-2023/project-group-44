package view;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Captcha extends Application {
    public static Stage captchaStage = new Stage() ;
    @FXML
    private ImageView captchaImage;
    @FXML
    private PasswordField captchaField;
    @FXML
    private Button verifyButton;
    private static String nameOfImage = null;
    private Popup popup = new Popup();
    private Label pLabel = new Label();
    private static final HashMap<String, Integer> captchaMap = new HashMap<>();
    private static Random random = new Random();
    private PauseTransition pause = new PauseTransition(Duration.seconds(3));
    private int credit = 3;



    @Override
    public void start(Stage stage) throws Exception {
        Captcha.captchaStage = stage;
        Pane pane = FXMLLoader.load(
                new URL(Main.class.getResource("/fxml/CaptchaFXML.fxml").toExternalForm()));

        Image img = new Image(Main.class.getResource("/images/captchaBG.png").toExternalForm());
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        pane.setBackground(bGround);

        Scene scene = new Scene(pane, 350, 400);
        captchaStage.setResizable(false);
        captchaStage.setScene(scene);
        captchaStage.show();
    }

    @FXML
    public void initialize() throws Exception{
        captchaMap.put("1181.png", 0);
        captchaMap.put("1381.png", 1);
        captchaMap.put("1491.png", 2);
        captchaMap.put("1722.png", 3);
        captchaMap.put("1959.png", 4);
        captchaMap.put("2163.png", 5);
        captchaMap.put("2177.png", 6);
        captchaMap.put("2785.png", 7);
        captchaMap.put("3541.png", 8);
        captchaMap.put("3847.png", 9);
        captchaMap.put("3855.png", 10);
        captchaMap.put("3876.png", 11);
        captchaMap.put("3967.png", 12);
        captchaMap.put("4185.png", 13);
        captchaMap.put("4310.png", 14);
        captchaMap.put("4487.png", 15);
        captchaMap.put("4578.png", 16);
        captchaMap.put("4602.png", 17);
        captchaMap.put("4681.png", 18);
        captchaMap.put("4924.png", 19);
        captchaMap.put("5326.png", 20);
        captchaMap.put("5463.png", 21);
        captchaMap.put("5771.png", 22);
        captchaMap.put("5849.png", 23);
        captchaMap.put("6426.png", 24);
        captchaMap.put("6553.png", 25);
        captchaMap.put("6601.png", 26);
        captchaMap.put("6733.png", 27);
        captchaMap.put("6960.png", 28);
        captchaMap.put("7415.png", 29);
        captchaMap.put("7609.png", 30);
        captchaMap.put("7755.png", 31);
        captchaMap.put("7825.png", 32);
        captchaMap.put("7905.png", 33);
        captchaMap.put("8003.png", 34);
        captchaMap.put("8070.png", 35);
        captchaMap.put("8368.png", 36);
        captchaMap.put("8455.png", 37);
        captchaMap.put("8506.png", 38);
        captchaMap.put("8555.png", 39);
        captchaMap.put("8583.png", 40);
        captchaMap.put("8692.png", 41);
        captchaMap.put("8776.png", 42);
        captchaMap.put("8972.png", 43);
        captchaMap.put("8996.png", 44);
        captchaMap.put("9061.png", 45);
        captchaMap.put("9386.png", 46);
        captchaMap.put("9582.png", 47);
        captchaMap.put("9633.png", 48);

        pLabel.setMinWidth(300);
        pLabel.setMinWidth(130);
        pLabel.setPadding(new Insets(20));
        popup.getContent().add(pLabel);
        popup.setAutoHide(true);
        setCaptcha();
    }


    public void onVerifyClick(ActionEvent event) throws Exception {
        String code = nameOfImage.replace(".png", "");
        if (captchaField.getText().equals(code)) {
            pLabel.setText("Captcha Verified!");
            pLabel.setStyle("-fx-background-color: #08f080; -fx-font-color: #075238; -fx-font-size: 25; -fx-font-weight: bold");
            popup.show(captchaStage);
            LoginMenu.captchaVerification = true;
            pause.setOnFinished(e -> captchaStage.close());
            pause.play();
        } else {
            credit --;
            pLabel.setText("Captcha Failed!");
            pLabel.setStyle("-fx-background-color: #ef4b4b; -fx-font-color: #075238; -fx-font-size: 25; -fx-font-weight: bold");
            popup.show(captchaStage);
            pause.setOnFinished(e -> {
                popup.hide();
                setCaptcha();
                captchaField.setText("");
            });
            pause.play();

        }
    }

    public void setCaptcha() {
        if (credit == 0){
            captchaStage.close();
        }
        int randomIndex = random.nextInt(49);
        for (Map.Entry<String, Integer> entry : captchaMap.entrySet()) {
            if (entry.getValue() == randomIndex) {
                nameOfImage = entry.getKey();
                break;
            }
        }
        String address = "/Captcha/".concat(nameOfImage);
        Image image = new Image(Main.class.getResource(address).toExternalForm());
        captchaImage.setImage(image);
    }
}



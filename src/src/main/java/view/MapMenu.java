package view;

import controller.LoginMenuController;
import controller.MapController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;

public class MapMenu extends Application {

    private static final int[][] mapData = new int[300][200];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // .:: Initial Design ::.
        initialDesign(mapData);

        // .:: Create and add the cells to the gridPane ::.
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 200; y++) {
                StackPane cellPane = new StackPane();
                Image textureImage = getTextureImage(mapData[x][y]);
                ImageView imageView = new ImageView(textureImage);
                imageView.setFitWidth(4);
                imageView.setFitHeight(4);

                cellPane.getChildren().add(imageView);

                gridPane.add(cellPane, x, y);
            }
        }

        // .:: Zoom with Mouse Scroll ::.
        double initialScale = 1.0;
        Scale scaleTransform = new Scale(initialScale, initialScale);
        gridPane.getTransforms().add(scaleTransform);

        gridPane.addEventFilter(ScrollEvent.SCROLL, event -> {
            double zoomFactor = 1.1; // Adjust the zoom factor as desired
            double deltaY = event.getDeltaY();

            if (deltaY < 0) {
                // Zoom in
                scaleTransform.setX(scaleTransform.getX() * zoomFactor);
                scaleTransform.setY(scaleTransform.getY() * zoomFactor);
            } else {
                // Zoom out only if the current scale is larger than the initial scale
                if (scaleTransform.getX() > initialScale && scaleTransform.getY() > initialScale) {
                    scaleTransform.setX(scaleTransform.getX() / zoomFactor);
                    scaleTransform.setY(scaleTransform.getY() / zoomFactor);
                }
            }
            event.consume();
        });

        Scene scene = new Scene(gridPane, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /*  GUIDE:
         :: 1(plain1),
         :: 2(mountain),
         :: 3(sea),
         :: 4(grass) */
    public static void initialDesign (int [][] mapData){
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 200; j++) {
                mapData[i][j] = 1;
            }
        }
        for (int i = 0; i < 300; i++) {
            for (int j = 1; j < 11; j++) {
                mapData[i][j] = 4;
            }
            for (int j = 189; j < 199; j++) {
                mapData[i][j] = 4;
            }
            mapData[i][0] = 2;
            mapData[i][199] = 2;
        }
        for (int j = 0; j < 200; j++) {
            for (int i = 1; i < 11; i++) {
                mapData[i][j] = 4;
            }
            for (int i = 289; i < 299; i++) {
                mapData[i][j] = 4;
            }
            mapData[0][j] = 2;
            mapData[299][j] = 2;
        }
        for (int i = 20; i < 30; i++) {
            for (int j = 20; j < 30; j++) {
                mapData[i][j] = 3;
            }
        }
    }

    private Image getTextureImage(int textureID) {
        return switch (textureID) {
            case 1 ->
                    new Image(Objects.requireNonNull(MapMenu.class.getResource("/images/Tiles/Plain1.jpg")).toExternalForm());
            case 2 ->
                    new Image(Objects.requireNonNull(MapMenu.class.getResource("/images/Tiles/Mountain1.png")).toExternalForm());
            case 3 ->
                    new Image(Objects.requireNonNull(MapMenu.class.getResource("/images/Tiles/Sea1.jpg")).toExternalForm());
            case 4 ->
                    new Image(Objects.requireNonNull(MapMenu.class.getResource("/images/Tiles/Grass1.png")).toExternalForm());
            default -> null;
        };
    }


    public void run(Scanner scanner, Matcher matcher) {
        String command;
        Matcher mapMatcher;
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        MapController.showMap(x, y);
        String moveMapRegex = "^map(?=.*\\s+left\\s+(?<left>[0-9]+))?(?=.*\\s+right\\s+(?<right>[0-9]+))?" +
                "(?=.*\\s+up\\s+(?<up>[0-9]+))?(?=.*\\s+down\\s+(?<down>[0-9]+))?.*$";
        String mapDetailRegex = "^show\\s+details(?=.*\\s+-x\\s+(?<x>[0-9]+))?(?=.*\\s+-y\\s+(?<y>[0-9]+))?.*$";
        while (true) {
            command = scanner.nextLine();
            if ((mapMatcher = LoginMenuController.getMatcher(command, moveMapRegex)) != null) {
                x = MapController.moveMapX(mapMatcher, command, x);
                y = MapController.moveMapY(mapMatcher, command, y);
                MapController.showMap(x, y);
            } else if ((mapMatcher = LoginMenuController.getMatcher(command, mapDetailRegex)) != null) {
                MapController.showDetails(Integer.parseInt(mapMatcher.group("x")), Integer.parseInt(mapMatcher.group("y")));
            } else if (LoginMenuController.getMatcher(command, "^exit$") != null) {
                return;
            } else System.out.println("Invalid command");
        }
    }
}

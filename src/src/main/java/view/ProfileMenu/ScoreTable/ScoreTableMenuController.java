package view.ProfileMenu.ScoreTable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import model.App;
import model.User;
import target.classes.model.Point;
import view.Main;
import view.ProfileMenu.ProfileMenuRun;

import java.util.ArrayList;

public class ScoreTableMenuController {
    public TableView scoreTable;
    public void initialize(){
            ArrayList<User> sortedListOfUsers=controller.ProfileMenuController.sortUsersByDifficulty();
            ObservableList<Point> points = FXCollections.observableArrayList();
            for(int i=0;i<sortedListOfUsers.size() && i<10;i++){
                points.add(new Point(i+1,sortedListOfUsers.get(i).getUsername(),sortedListOfUsers.get(i).getScore()));
            }
            scoreTable.setItems(points);

            scoreTable.setRowFactory(tv -> new TableRow<Point>(){
                protected void updateItem(Point item, boolean empty){
                    super.updateItem(item,empty);
                    if (getIndex() == 0) {
                        setStyle("-fx-background-color: yellow;");
                    } else if (getIndex() == 1) {
                        setStyle("-fx-background-color: grey;");
                    } else if (getIndex() == 2) {
                        setStyle("-fx-background-color: orange;");
                    } else {
                        setStyle("");
                    }
                }
            });
    }

    public void Back(MouseEvent mouseEvent) throws Exception {
        new ProfileMenuRun().start(Main.stage);
    }
}

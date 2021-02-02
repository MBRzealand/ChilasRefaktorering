import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Cat;
import logic.Lazers;

import java.io.IOException;
public class Controller  {
    int deathcounterint = 0;
    int scorecounter = 0;
    int plusscore= 0;
    Cat cat = new Cat();
    Lazers lazers = new Lazers();
    Score score = new Score();
    @FXML
    GridPane grid;
    @FXML
    AnchorPane pane = new AnchorPane();
    @FXML
    Label left,right,up,down,deathcounter,scoreboard;
    @FXML
    void createbutton(){
        Button btn = new Button("ok");
        btn.setOnKeyPressed( event ->{
            switch (event.getCode()){
                case W:
                    up.setOpacity(1);
                    cat.minusy();
                    break;
                case S:
                    down.setOpacity(1);
                    cat.plusy();
                    break;
                case A:
                    left.setOpacity(1);
                    cat.minusx();
                    break;
                case D:
                    right.setOpacity(1);
                    cat.plusx();
                    break;
                }
        });
        btn.setOnKeyReleased( event ->{
                    right.setOpacity(0.25);
                    up.setOpacity(0.25);
                    down.setOpacity(0.25);
                    left.setOpacity(0.25);
            runmetods();
                });
        pane.getChildren().add(btn);
    }
@FXML
    void runmetods(){
        checkdeathandcoins();
        cat.checkcoordiantes();
        updategrid(); }
@FXML
void updategrid(){
    grid.getChildren().clear();
    grid.add(cat.getImageView() ,cat.x,cat.y);
    //lazerpick
   lazers.newrandomx();
   lazers.newrandomy();
    //xxpictures
    for (int i = 0; i <9 ; i++) {
       grid.add(lazers.getImageview1to8()[i],lazers.getLazerxnow(),i);
    }
    //ypictures
    for (int i = 0; i <9 ; i++) {
        if (i != lazers.getLazerxnow() ){
            grid.add(lazers.getImageview20to28()[i],i,lazers.getLazerynow());
        }
    }
    //nextxtonow
    for (int i = 0; i <9 ; i++) {
            grid.add(lazers.getImageview10to18()[i], lazers.getLazerxnext(),i);
    }
    lazers.lazerxnowtonext();
    for (int i = 0; i <9 ; i++) {
        if (i != lazers.getLazerxnext() ){
            grid.add(lazers.getImageview30to38()[i], i,lazers.getLazerynext());
        }
    }
    lazers.lazerynowtonext();
    //addcoins
    plusscore = score.getPlusscore() ;
    grid.add(score.getImageView(), score.getX(), score.getY());
}
@FXML
void checkdeathandcoins(){
    if (cat.deadornot(lazers.getLazerxnow(),lazers.getLazerynow())){
        deathcounterint++;
        deathcounter.setText("Times died " + deathcounterint);
        if(deathcounterint % 3 == 0){
            scorecounter = 0;
            scoreboard.setText("Your score is  " + scorecounter);
        }
    }
    if (score.pickedornor(cat.x,cat.y)){
        scorecounter = scorecounter + plusscore;
        score.newrandomcoordinates();
       scoreboard.setText("Your score is  " + scorecounter);
    }
}
@FXML
void resetgame(javafx.event.ActionEvent event)throws IOException {
        //not correct way to reset game, but it works for now
        Parent blah = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }
}
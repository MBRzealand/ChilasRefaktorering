import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
public class Controller {
    int deathcounterint = 0;
    Cat cat = new Cat();
    Lazers lazers = new Lazers();
    @FXML
    GridPane grid;
    @FXML
    AnchorPane pane = new AnchorPane();
    @FXML
    Label left,right,up,down,deathcounter;
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
            checkcoordinates();
            cat.checkcoordiantes();
        });
        btn.setOnKeyReleased( event ->{
                    right.setOpacity(0.25);
                    up.setOpacity(0.25);
                    down.setOpacity(0.25);
                    left.setOpacity(0.25);
          updategrid();
                });
        pane.getChildren().add(btn);
    }
@FXML
void updategrid(){
    grid.getChildren().clear();
    grid.add(cat.getImageView() ,cat.x,cat.y);
    //lazerpick
   lazers.newrandomx();
   lazers.newrandomy();
    //xxpictures
    for (int i = 0; i <8 ; i++) {
       grid.add(lazers.getImageview1to8()[i],lazers.getLazerxnow(),i);
    }
    //ypictures
    for (int i = 0; i <8 ; i++) {
        if (i != lazers.getLazerxnow() ){
            grid.add(lazers.getImageview20to28()[i],i,lazers.getLazerynow());
        }
    }
    //nextxtonow
    for (int i = 0; i <8 ; i++) {
            grid.add(lazers.getImageview10to18()[i], lazers.getLazerxnext(),i);
    }
    lazers.lazerxnowtonext();
    for (int i = 0; i <8 ; i++) {
        if (i != lazers.getLazerxnext() ){
            grid.add(lazers.getImageview30to38()[i], i,lazers.getLazerynext());
        }
    }
    lazers.lazerynowtonext();
}
void checkcoordinates(){
    if (cat.deadornot(lazers.getLazerxnow(),lazers.getLazerynow())){
        deathcounterint++;
        deathcounter.setText("You have died " + deathcounterint + " times");
    }
}
}

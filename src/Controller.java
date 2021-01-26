import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
public class Controller  {
    int deathcounterint = 0;
    int moneyscounter = 0;
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
        deathcounter.setText("You have died " + deathcounterint + " times");
        if(deathcounterint == 3){
        }
    }
    if (score.pickedornor(cat.x,cat.y)){
        moneyscounter= moneyscounter + plusscore;
        score.newrandomcoordinates();
       scoreboard.setText("Your score is  " + moneyscounter);
    }
}
@FXML
void timer(){
    SnakkesagligPerson p = new SnakkesagligPerson("Jacob",15000); // opret Jacob
    Thread t = new Thread(p); // Ny tråd, klar til at udføre p.run()
    t.start();
}
}
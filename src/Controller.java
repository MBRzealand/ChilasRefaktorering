import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.util.*;

public class Controller {
    int x = 2;
    int y = 2 ;
    int lazerxnext = 0 ;
    int lazerxnow  = 0 ;
    int deathcounterint = 0;
    int lazerynow = 0;
     int lazerynext = 0;
    @FXML
    ImageView imageView = new ImageView();
    @FXML
    ImageView[] imageview1to8 = new ImageView[8];
    ImageView[] imageview10to18 = new ImageView[8];
    ImageView[] imageview20to28 = new ImageView[8];
    ImageView[] imageview30to38 = new ImageView[8];
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
                   y--;
                    break;
                case S:
                    down.setOpacity(1);
                    y++;
                    break;
                case A:
                    left.setOpacity(1);
                    x--;
                    break;
                case D:
                    right.setOpacity(1);
                    x++;
                    break;
                }
            checkcoordinates();
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
    imageView.setImage( new Image("Pictures/cat.png"));
    grid.add(imageView ,x,y);
    //lazerpick
    Random random = new Random();
    int rngx = random.nextInt(9);
    int rngy = random.nextInt(9);
    lazerxnext = rngx;
    lazerynext = rngy;

    //xxpictures
    for (int i = 0; i <imageview1to8.length ; i++) {
        imageview1to8[i] = new ImageView();
        imageview1to8[i].setImage(new Image("Pictures/Lazer.png",100,100,false,false));
    }
    for (int i = 0; i <imageview1to8.length ; i++) {
       grid.add(imageview1to8[i],lazerxnow,i);
    }
    //ypictures
    for (int i = 0; i < imageview20to28.length; i++) {
        imageview20to28[i] = new ImageView();
        imageview20to28[i].setImage(new Image("Pictures/Lazeryværdi.png",100,100,false,false));
    }
    for (int i = 0; i <imageview20to28.length ; i++) {
        if (i != lazerxnow ){
            grid.add(imageview20to28[i],i,lazerynow);
        }
    }
    //nextxtonow
    for (int i = 0; i < imageview10to18.length; i++) {
        imageview10to18[i] = new ImageView();
        imageview10to18[i].setImage(new Image("Pictures/Lazernext.png",100,100,false,false));
    }
    for (int i = 0; i <imageview10to18.length ; i++) {
            grid.add(imageview10to18[i],lazerxnext,i);
    }
    lazerxnow = lazerxnext;
    //nextxtonowy
    for (int i = 0; i < imageview30to38.length; i++) {
        imageview30to38[i] = new ImageView();
        imageview30to38[i].setImage(new Image("Pictures/Lazeryværdinext.png",100,100,false,false));
    }
    for (int i = 0; i <imageview30to38.length ; i++) {
        if (i != lazerxnext ){
            grid.add(imageview30to38[i],i,lazerynext);
        }
    }
    lazerynow = lazerynext;
}
void checkcoordinates(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
    if (x > 8){ x = 8; }
    if (y > 8){ y = 8; }
    if (x == lazerxnow | y == lazerynow ){
        System.out.println("you died");
        deathcounterint++;
        deathcounter.setText("You have died " + deathcounterint + " times");
    }
}
}
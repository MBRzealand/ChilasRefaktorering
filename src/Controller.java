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
    @FXML
    ImageView imageView = new ImageView();
    @FXML
    ImageView imageViewred = new ImageView();
    ImageView imageView0 = new ImageView();
    ImageView imageView1= new ImageView();
    ImageView imageView2= new ImageView();
    ImageView imageView3= new ImageView();
    ImageView imageView4= new ImageView();
    ImageView imageView5= new ImageView();
    ImageView imageView6= new ImageView();
    ImageView imageView7= new ImageView();
    ImageView imageView8= new ImageView();
    @FXML
    ImageView imageViewreddot = new ImageView();
    @FXML
    GridPane grid;
    @FXML
    AnchorPane pane = new AnchorPane();
    @FXML
    Label left,right,up,down,x0,x1,x2,x3,x4,x5,x6,x7,x8;
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
           // emptylabels();
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
    imageView.setImage( new Image("cat.png"));
    grid.add(imageView ,x,y);
    //lazerpick
    Random random = new Random();
    int rngx = random.nextInt(9);
    lazerxnext = rngx;


    ArrayList<ImageView> redlinearray  = new ArrayList<>();
    redlinearray.addAll(Arrays.asList(imageView0 ,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8));
    for (int i = 0; i < 9; i++) {
        redlinearray.get(i).setImage( new Image("Lazer.png",100,100,false,false));
    }
    for (int i = 0; i <9 ; i++) {
        grid.add(redlinearray.get(i),lazerxnext,i);
    }



    //nexttonow
    imageViewreddot.setImage( new Image("red.png",100,100,false,false));
    grid.add(imageViewreddot,lazerxnow,0);
    lazerxnow = lazerxnext;
}

void checkcoordinates(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
    if (x > 8){ x = 8; }
    if (y > 8){ y = 8; }
    if (x == lazerxnow ){
        System.out.println("you died");
    }
}








@FXML
void deathlazerxpick(){
    Random random = new Random();
    int rngx = random.nextInt(9);
    lazerxnext = rngx;
   /* switch (rngx){
        case 0:
            x0.setText("here now");
            break;
        case 1:
            x1.setText("here now");
            break;
        case 2:
            x2.setText("here now");
            break;
        case 3:
            x3.setText("here now");
            break;
        case 4:
            x4.setText("here now");
            break;
        case 5:
            x5.setText("here now");
            break;
        case 6:
            x6.setText("here now");
            break;
        case 7:
            x7.setText("here now");
            break;
        case 8:
            x8.setText("here now");
            break;
    }*/
    imageViewred.setImage( new Image("Lazer.png",100,100,false,false));
    grid.add(imageViewred,lazerxnext,0);

  /*  ArrayList<ImageView> redlinearray  = new ArrayList<>();
    redlinearray.addAll(Arrays.asList(imageView0 ,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8));
    for (int i = 0; i < 9 ; i++) {
        redlinearray.get(i).setImage(new Image("Lazer.png",100,100,false,false));
    }
    for (int i = 0; i < 9; i++) {
        grid.add(redlinearray.get(i),lazerxnow,i);
    } */
}
void emptylabels(){
    ArrayList<Label> labellist = new ArrayList();
    labellist.addAll(Arrays.asList(x0,x1,x2,x3,x4,x5,x6,x7,x8));
    for (int i = 0; i < 9; i++) {
        labellist.get(i).setText("___");
    }
}

void nexttonow(){
    imageViewreddot.setImage( new Image("red.png",100,100,false,false));
    grid.add(imageViewreddot,lazerxnow,0);
    lazerxnow = lazerxnext;
}
}
















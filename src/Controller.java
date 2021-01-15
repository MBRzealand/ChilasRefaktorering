import javafx.application.Platform;
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
    ImageView imageViewred = new ImageView();
    Image lazer = new Image("Lazer.png");
    //ImageView imageView0,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8 = new ImageView(lazer);
    //ImageView       imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18 = new ImageView();
    ImageView[] imageview1to8 = new ImageView[8];

 /*   ImageView imageView1= new ImageView();
    ImageView imageView2= new ImageView();
    ImageView imageView3= new ImageView();
    ImageView imageView4= new ImageView();
    ImageView imageView5= new ImageView();
    ImageView imageView6= new ImageView();
    ImageView imageView7= new ImageView();
    ImageView imageView8= new ImageView();*/
    ImageView imageView10 = new ImageView();
    ImageView imageView11= new ImageView();
    ImageView imageView12= new ImageView();
    ImageView imageView13= new ImageView();
    ImageView imageView14= new ImageView();
    ImageView imageView15= new ImageView();
    ImageView imageView16= new ImageView();
    ImageView imageView17= new ImageView();
    ImageView imageView18= new ImageView();

    ImageView imageView20 = new ImageView();
    ImageView imageView21= new ImageView();
    ImageView imageView22 = new ImageView();
    ImageView imageView23= new ImageView();
    ImageView imageView24= new ImageView();
    ImageView imageView25= new ImageView();
    ImageView imageView26= new ImageView();
    ImageView imageView27= new ImageView();
    ImageView imageView28= new ImageView();

    ImageView imageView30 = new ImageView();
    ImageView imageView31= new ImageView();
    ImageView imageView32 = new ImageView();
    ImageView imageView33= new ImageView();
    ImageView imageView34= new ImageView();
    ImageView imageView35= new ImageView();
    ImageView imageView36= new ImageView();
    ImageView imageView37= new ImageView();
    ImageView imageView38= new ImageView();
    ImageView[] imageViewynext = new ImageView[8];
    @FXML
    ImageView imageViewreddot = new ImageView();
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
    int rngy = random.nextInt(9);
    lazerxnext = rngx;
    lazerynext = rngy;

    //xxpictures
   // ArrayList<ImageView> redlinearray  = new ArrayList<>();
  //  redlinearray.addAll(Arrays.asList(imageView0 ,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8));
    for (int i = 0; i <imageview1to8.length ; i++) {
        imageview1to8[i] = new ImageView();
        imageview1to8[i].setImage(new Image("Lazer.png",100,100,false,false));
    }

   //for (int i = 0; i < 9; i++) {
       // redlinearray.get(i).setImage( new Image("Lazer.png",100,100,false,false));
       // imageview1to8[i].setImage(new Image("Lazer.png",100,100,false,false));
   // }
    for (int i = 0; i <imageview1to8.length ; i++) {
     //  grid.add(redlinearray.get(i),lazerxnow,i);
       grid.add(imageview1to8[i],lazerxnow,i);
    }
    //ypictures

    ArrayList<ImageView> redlinearrayy  = new ArrayList<>();
    redlinearrayy.addAll(Arrays.asList(imageView20 ,imageView21,imageView22,imageView23,imageView24,imageView25,imageView26,imageView27,imageView28));
    for (int i = 0; i < 9; i++) {
        redlinearrayy.get(i).setImage( new Image("Lazeryværdi.png",100,100,false,false));
    }
    for (int i = 0; i <9 ; i++) {
        if (i != lazerxnow ){
            grid.add(redlinearrayy.get(i),i,lazerynow);
        }
    }


    //nextxtonow
    imageViewreddot.setImage( new Image("red.png",100,100,false,false));
    ArrayList<ImageView> redlinenext  = new ArrayList<>();
    redlinenext.addAll(Arrays.asList(imageView10 ,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18));
    for (int i = 0; i < 9; i++) {
        redlinenext.get(i).setImage( new Image("Lazernext.png",100,100,false,false));
    }
    for (int i = 0; i <9 ; i++) {
        grid.add(redlinenext.get(i),lazerxnext,i);
    }
    lazerxnow = lazerxnext;

    //nextxtonowy
    ArrayList<ImageView> redlinenexty  = new ArrayList<>();
    redlinenexty.addAll(Arrays.asList(imageView30 ,imageView31,imageView32,imageView33,imageView34,imageView35,imageView36,imageView37,imageView38));
    for (int i = 0; i < 9; i++) {
        redlinenexty.get(i).setImage( new Image("Lazeryværdinext.png",100,100,false,false));
    }
    for (int i = 0; i <9 ; i++) {
        if (i != lazerxnext ){
            grid.add(redlinenexty.get(i),i,lazerynext);
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

    public void moveElement(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Timer time = new Timer();
                time.scheduleAtFixedRate(new TimerTask(){
                    public void run(){
                        System.out.println("something");
                        updategrid();
                    }
                }, 10, 1000);
            }
        });
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
/*void emptylabels(){
    ArrayList<Label> labellist = new ArrayList();
    labellist.addAll(Arrays.asList(x0,x1,x2,x3,x4,x5,x6,x7,x8));
    for (int i = 0; i < 9; i++) {
        labellist.get(i).setText("___");
    }
}*/

void nexttonow(){
    imageViewreddot.setImage( new Image("red.png",100,100,false,false));
    grid.add(imageViewreddot,lazerxnow,0);
    lazerxnow = lazerxnext;
}
}



















import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
public class Lazers {
    int lazerxnext = 0 ;
    int lazerxnow  = 0 ;
    int lazerynow = 0;
    int lazerynext = 0;
    Random random = new Random();
    @FXML
    ImageView[] imageview1to8 = new ImageView[9];
    ImageView[] imageview10to18 = new ImageView[9];
    ImageView[] imageview20to28 = new ImageView[9];
    ImageView[] imageview30to38 = new ImageView[9];
    public Lazers() {
        xxpictures();
        ypictures();
        nextxtonow();
        nextxtonowy();
    }
    public int getLazerxnext() {
        return lazerxnext;
    }
    public int getLazerxnow() {
        return lazerxnow;
    }
    public int getLazerynow() { return lazerynow; }
    public int getLazerynext() {
        return lazerynext;
    }
    public ImageView[] getImageview1to8() {
        return imageview1to8;
    }
    public ImageView[] getImageview10to18() {
        return imageview10to18;
    }
    public ImageView[] getImageview20to28() {
        return imageview20to28;
    }
    public ImageView[] getImageview30to38() {
        return imageview30to38;
    }
    void newrandomx() {
        //lazerpick
        lazerxnext =  random.nextInt(9);
    }
    void newrandomy(){
        lazerynext = random.nextInt(9);
    }
    void lazerxnowtonext(){
        lazerxnow = lazerxnext;}
    void lazerynowtonext(){
        lazerynow = lazerynext;
    }
    void xxpictures(){
    for (int i = 0; i <imageview1to8.length ; i++) {
        imageview1to8[i] = new ImageView();
        imageview1to8[i].setImage(new Image("assets/Lazer.png",100,100,false,false));
    } }
    void ypictures(){
    for (int i = 0; i < imageview20to28.length; i++) {
        imageview20to28[i] = new ImageView();
        imageview20to28[i].setImage(new Image("assets/Lazeryværdi.png",100,100,false,false));
    }
    }
    void nextxtonow(){
    for (int i = 0; i < imageview10to18.length; i++) {
        imageview10to18[i] = new ImageView();
        imageview10to18[i].setImage(new Image("assets/Lazernext.png",100,100,false,false));
    }}
    void nextxtonowy(){
    for (int i = 0; i < imageview30to38.length; i++) {
        imageview30to38[i] = new ImageView();
        imageview30to38[i].setImage(new Image("assets/Lazeryværdinext.png",100,100,false,false));
    }}}
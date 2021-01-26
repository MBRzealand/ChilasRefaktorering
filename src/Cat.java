import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cat {
    int x ;
    int y ;
    public ImageView getImageView() {
        return imageView;
    }
    @FXML
    ImageView imageView = new ImageView();
    public Cat() {
         x = 2;
         y = 2;
        imageView.setImage(new Image("Pictures/cat.png"));
    }

    void plusx(){
        x++;
    }

    void plusy(){
        y++;
    }
    void minusx(){
        x--;
    }

    void minusy(){
        y--;
    }
    Boolean deadornot(int lx , int yl){
        if (x == lx | y == yl ){
            System.out.println("you died");
            return true;
        }
        return false;
    }
    void checkcoordiantes(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
        if (x > 8){ x = 8; }
        if (y > 8){ y = 8; }
    }


}

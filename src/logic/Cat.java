package logic;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Cat {
    public int x ;
    public int y ;
    public ImageView getImageView() {
        return imageView;
    }
    @FXML
    ImageView imageView = new ImageView();
    public Cat() {
         x = 2;
         y = 2;
        imageView.setImage(new Image("assets/cat.png"));
    }
    public void plusx(){
        x++;
    }
    public void plusy(){
        y++;
    }
    public void minusx(){
        x--;
    }

    public void minusy(){
        y--;
    }
    public Boolean deadornot(int lx , int yl){
        if (x == lx | y == yl ){
            System.out.println("you died");
            return true;
        }
        return false;
    }
    public void checkcoordiantes(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
        if (x > 8){ x = 8; }
        if (y > 8){ y = 8; }
    }
}

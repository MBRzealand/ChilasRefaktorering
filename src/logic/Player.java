package logic;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    public int x ;
    public int y ;

    public ImageView getImageView() {
        return imageView;
    }    // GUI does not belong in logic classes

    @FXML
    ImageView imageView = new ImageView();

    public Player() {
         x = 2;
         y = 2;
        imageView.setImage(new Image("assets/cat.png"));
    }

    public void moveRight(){
        x++;
    }

    public void moveUp(){
        y++;
    }

    public void moveLeft(){
        x--;
    }

    public void moveDown(){
        y--;
    }


    public boolean isAlive(int lx , int yl){
        if (x == lx | y == yl ){
            return true;
        }
        return false;
    }

    public void checkCoordinates(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
        if (x > 8){ x = 8; }
        if (y > 8){ y = 8; }
    }
}

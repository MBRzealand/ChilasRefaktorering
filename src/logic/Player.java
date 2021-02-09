package logic;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private int x ;
    private int y ;
    private ImageView playerImageView;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getPlayerImage() {
        return playerImageView;
    }

    public void setPlayerImage(ImageView playerImage) {
        this.playerImageView = playerImage;
    }

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.playerImageView = new ImageView("assets/cat.png");
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

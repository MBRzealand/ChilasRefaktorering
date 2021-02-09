package logic;

import javafx.scene.image.ImageView;

public class Player {
    private int x ;
    private int y ;
    private final ImageView PLAYERIMAGEVIEW;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageView getPlayerImage() {
        return PLAYERIMAGEVIEW;
    }

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.PLAYERIMAGEVIEW = new ImageView("assets/cat.png");
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
        return x == lx | y == yl;
    }

    public void checkCoordinates(){
        if (x < 0){ x = 0; }
        if (y < 0){ y = 0; }
        if (x > 8){ x = 8; }
        if (y > 8){ y = 8; }
    }
}

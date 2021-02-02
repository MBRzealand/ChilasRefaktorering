package logic;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Lazers {
    int lazerxnext = 0;
    int lazerxnow = 0;
    int lazerynow = 0;
    int lazerynext = 0;
    Random random = new Random();


    public Lazers() {

    }

    public int getLazerxnext() {
        return lazerxnext;
    }

    public int getLazerxnow() {
        return lazerxnow;
    }

    public int getLazerynow() {
        return lazerynow;
    }

    public int getLazerynext() {
        return lazerynext;
    }


    public void newrandomx() {
        //lazerpick
        lazerxnext = random.nextInt(9);
    }

    public void newrandomy() {
        lazerynext = random.nextInt(9);
    }

    public void lazerxnowtonext() {
        lazerxnow = lazerxnext;
    }

    public void lazerynowtonext() {
        lazerynow = lazerynext;
    }

}
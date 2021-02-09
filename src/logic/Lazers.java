package logic;
import java.util.Random;

public class Lazers {
    //Variables
    int lazerXNext = 0;
    int lazerXCurrent = 0;
    int lazerYCurrent = 0;
    int lazerYNext = 0;
    Random lazerPosition = new Random();

    public Lazers() {
    }

    //Getting lazer posistion
    public int getLazerXNext() {
        return lazerXNext;
    }

    public int getLazerXCurrent() {
        return lazerXCurrent;
    }

    public int getLazerYCurrent() {
        return lazerYCurrent;
    }

    public int getLazerYNext() {
        return lazerYNext;
    }

    //Setting lazer position
    public void generateRandomLazerX() {

        lazerXNext = lazerPosition.nextInt(9);
    }

    public void generateRandomLazerY() {
        lazerYNext = lazerPosition.nextInt(9);
    }

    public void setNewCurrentLazerX() {
        lazerXCurrent = lazerXNext;
    }

    public void setNewCurrentLazerY() {
        lazerYCurrent = lazerYNext;
    }

}
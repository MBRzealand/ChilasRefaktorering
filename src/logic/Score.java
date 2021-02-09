package logic;

import java.util.ArrayList;
import java.util.Random;
public class Score {
    private final ArrayList<ScoreObserver> COLLECTIONOFSCOREOBSERVERS = new ArrayList<>();
    private int x;
    private  int y;
    private final Random RANDOMIDEACOORDINATE = new Random();
    private int plusScore;
    public int getPlusScore() { return plusScore +1; }
    
    public Score() { generateIdea(); }

    public void generateIdea(){
        x =  RANDOMIDEACOORDINATE.nextInt(9);
        y =  RANDOMIDEACOORDINATE.nextInt(9);
        plusScore = RANDOMIDEACOORDINATE.nextInt(3);

        notifyObservers();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean isOnTopOfIdea(int ideaPositionX, int ideaPositionY){
        return x == ideaPositionX & y == ideaPositionY;
    }

    private void notifyObservers() {
        for (ScoreObserver observer : COLLECTIONOFSCOREOBSERVERS) {
            observer.update();
        }
    }

    public void addScoreObserver(ScoreObserver observer) {
        if (!COLLECTIONOFSCOREOBSERVERS.contains(observer))
            COLLECTIONOFSCOREOBSERVERS.add(observer);
    }

    public interface ScoreObserver {
        void update();
    }
}
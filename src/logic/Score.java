package logic;

import java.util.ArrayList;
import java.util.Random;
public class Score {
    private ArrayList<ScoreObserver> collectionOfScoreObservers = new ArrayList<ScoreObserver>();
    private int x;
    private  int y;
    private Random random = new Random();
    private int plusScore;
    public int getPlusScore() { return plusScore +1; }
    
    public Score() { generateIdea(); }
    public void generateIdea(){
        x =  random.nextInt(9);
        y =  random.nextInt(9);
        plusScore = random.nextInt(3);

        notifyObservers();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Boolean isOnTopOfIdea(int ideaPositionX, int ideaPositionY){
        if (x == ideaPositionX & y == ideaPositionY ){
            return true;
        }
        return false;
    }

    private void notifyObservers() {
        for (ScoreObserver observer : collectionOfScoreObservers) {
            observer.update();
        }
    }

    public void addScoreObserver(ScoreObserver observer) {
        if (!collectionOfScoreObservers.contains(observer))
            collectionOfScoreObservers.add(observer);
    }


//    public void removeScoreObserver(ScoreObserver observer) {
//        collectionOfScoreObservers.remove(observer);
//    }


    public interface ScoreObserver {
        void update();
    }
}
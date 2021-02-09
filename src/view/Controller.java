package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import logic.Player;
import logic.Lazers;
import logic.Score;

import java.io.IOException;
public class Controller  {
    int deathCounterInt = 0;
    int scoreCounter = 0;
    int plusScore = 0;

    Player player = new Player(2,2);
    Lazers lazers = new Lazers();
    Score score = new Score();

    private final ImageView IMAGEVIEW = new ImageView();
    public ImageView getIMAGEVIEW() { return IMAGEVIEW; }

    @FXML
    GridPane grid;

    @FXML
    AnchorPane pane = new AnchorPane();

    @FXML
    Label left,right,up,down, deathCounter,scoreboard;

    @FXML
    Button startButton;

    @FXML
    void createButton(){
        displayLazersY();
        displayLazersX();
        setNextYToCurrent();
        setNextXToCurrent();
        newImage();

        score.addScoreObserver(new Score.ScoreObserver() {
            @Override
            public void update() {
                newImage();
            }
        });

        startButton.setOnKeyPressed( event ->{
            switch (event.getCode()) {
                case W -> {
                    up.setOpacity(1);
                    player.moveDown();
                }
                case S -> {
                    down.setOpacity(1);
                    player.moveUp();
                }
                case A -> {
                    left.setOpacity(1);
                    player.moveLeft();
                }
                case D -> {
                    right.setOpacity(1);
                    player.moveRight();
                }
            }
        });
        startButton.setOnKeyReleased( event ->{
            right.setOpacity(0.25);
            up.setOpacity(0.25);
            down.setOpacity(0.25);
            left.setOpacity(0.25);
            runMethods();
        });
    }

    @FXML
    void runMethods(){
        checkScores();
        player.checkCoordinates();
        updateGrid();
    }
    @FXML
    void updateGrid(){
        grid.getChildren().clear();
        grid.add(player.getPlayerImage(), player.getX(), player.getY());

        lazers.generateRandomLazerX();
        lazers.generateRandomLazerY();

        for (int i = 0; i <9 ; i++) {
           grid.add(getImageview1to8()[i],lazers.getLazerXCurrent(),i);
        }

        for (int i = 0; i <9 ; i++) {
            if (i != lazers.getLazerXCurrent() ){
                grid.add(getImageview20to28()[i],i,lazers.getLazerYCurrent());
            }
        }

        for (int i = 0; i <9 ; i++) {
                grid.add(getImageview10to18()[i], lazers.getLazerXNext(),i);
        }
        lazers.setNewCurrentLazerX();

        for (int i = 0; i <9 ; i++) {
            if (i != lazers.getLazerXNext() ){
                grid.add(getImageview30to38()[i], i,lazers.getLazerYNext());
            }
        }
        lazers.setNewCurrentLazerY();

        //addcoins
        plusScore = score.getPlusScore() ;
        grid.add(getIMAGEVIEW(), score.getX(), score.getY());
    }
    @FXML
    void checkScores(){
        if (player.isDead(lazers.getLazerXCurrent(),lazers.getLazerYCurrent())){
            deathCounterInt++;
            deathCounter.setText("Times died " + deathCounterInt);
            if(deathCounterInt % 3 == 0){
                scoreCounter = 0;
                scoreboard.setText("Your score is  " + scoreCounter);
            }
        }
        if (score.isOnTopOfIdea(player.getX(), player.getY())){
            scoreCounter = scoreCounter + plusScore;
            score.generateIdea();
            scoreboard.setText("Your score is  " + scoreCounter);
        }
    }
    @FXML
    void resetGame(javafx.event.ActionEvent event)throws IOException {
        Parent gui = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        Scene scene = new Scene(gui);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    void newImage(){
        switch (plusScore) {
            case 0 -> IMAGEVIEW.setImage(new Image("assets/bronze.png"));
            case 1 -> IMAGEVIEW.setImage(new Image("assets/silver.png"));
            case 2 -> IMAGEVIEW.setImage(new Image("assets/gold.png"));
        }
    }

    @FXML
    ImageView[] imageview1to8 = new ImageView[9];
    ImageView[] imageview10to18 = new ImageView[9];
    ImageView[] imageview20to28 = new ImageView[9];
    ImageView[] imageview30to38 = new ImageView[9];

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

    public void displayLazersY() {
        for (int i = 0; i < imageview1to8.length; i++) {
            imageview1to8[i] = new ImageView();
            imageview1to8[i].setImage(new Image("assets/LazerY.png", 100, 100, false, false));
        }
    }

    public void displayLazersX() {
        for (int i = 0; i < imageview20to28.length; i++) {
            imageview20to28[i] = new ImageView();
            imageview20to28[i].setImage(new Image("assets/LazerX.png", 100, 100, false, false));
        }
    }

    public void setNextYToCurrent() {
        for (int i = 0; i < imageview10to18.length; i++) {
            imageview10to18[i] = new ImageView();
            imageview10to18[i].setImage(new Image("assets/transparentLazerY.png", 100, 100, false, false));
        }
    }

    public void setNextXToCurrent() {
        for (int i = 0; i < imageview30to38.length; i++) {
            imageview30to38[i] = new ImageView();
            imageview30to38[i].setImage(new Image("assets/transparentLazerX.png", 100, 100, false, false));
        }
    }
}
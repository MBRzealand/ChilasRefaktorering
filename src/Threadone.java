import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Threadone implements Runnable {
    private String souttext;
    private int speed;

    public Threadone(String souttext, int speed) {
        this.souttext = souttext;
        this.speed = speed;
    }
    public void run()
    {
        Controller controller = new Controller();
        for (int i = 0; i <100 ; i++) {
            controller.grid.getChildren().clear();
          //  controller.imageView.setImage( new Image("Pictures/cat.png"));
         //   controller.grid.add(controller.imageView ,controller.x,controller.y);
            System.out.println(souttext);
            try {  Thread.sleep(speed); } catch (Exception e) {} // vent lidt

        }


    }
}

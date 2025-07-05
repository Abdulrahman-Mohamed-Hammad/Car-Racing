package org.example.demo23;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CAR_THREADS implements Runnable {
    Pane root;

    Scene scene;
    double carY;
    double carX;
    double carspeed=3;
    ImageView CAR;
    STAGE stage1;
    int x=1;
    boolean ISMOVE=true;
    Text t;


   public CAR_THREADS(Pane root,Scene scene,double carX ,double carY,STAGE stage1)
   {
       this.stage1=stage1;
       this.root=root;
       this.scene=scene;
       this.carX=carX;
       this.carY=carY;
   }




    public void MAKE_CAR(Image carimage )
   {

       ImageView imageview =new ImageView(carimage);
       imageview.setFitWidth(100);
       imageview.setFitHeight(100);
       this.CAR=imageview;
       imageview.setX(carX);

       imageview.setY(carY);

       root.getChildren().add(imageview);
   }
    void checks()
    {
        if(carY < -120)
        {
            carY=800;
            CAR.setY(carY);
            if(x==1)
            {
                stage1.swaps(CAR, carspeed, carX, carY);
                x=0;
            } else if (x==0) {
                root.getChildren().add(CAR);
                x=1;

            }

        }
    }

    @Override
    public void run() {
       checks();
        while (ISMOVE) {
            carY -= carspeed;
            Platform.runLater(() -> {
                checks();
                CAR.setY(carY);
                CAR.setX(carX);
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            checks();
        }
    }

}

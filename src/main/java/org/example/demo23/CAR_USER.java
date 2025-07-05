package org.example.demo23;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CAR_USER extends MAPING {
    Pane root;
    STAGE stage1;
    Scene scene;
    double carY;
    double carX;
    ImageView car;
   double carSpeed=3;
   int count =0;
   int SCORE =0;
   boolean isMovingForward=false;
   int x=1;
    private Set<KeyCode> pressedKeys = new HashSet<>();
    public CAR_USER(Scene scene , Pane root,STAGE stage1)
    {

        this.stage1=stage1;
        this.root =root;
        this.scene=scene;

        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));

    }
    public CAR_USER(){}
    void MAKE_CAR()
    {
        Image image = new Image("TOKTOK!.png");
        ImageView imageview =new ImageView(image);
        car =imageview;
        imageview.setFitWidth(100);
        imageview.setFitHeight(125);
        imageview.setRotate(180);
        carX = 325;
        imageview.setX(carX);
        carY = 600;
        imageview.setY(carY);
        car =imageview;
        root.getChildren().add(car);

            KEYBOARED();


        ANIMATION_TIME();

    }
    public void KEYBOARED() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();

                if (code == KeyCode.W) {
                    isMovingForward = true;
                    if (count < 2) {
                        if (code == KeyCode.W) {
                            carY -= 1;
                            ANIMATION_TIME();
                            count++;
                        }
                    }
                } else if (code == KeyCode.S) {
                    isMovingForward = false; // Stop the car's movement
                    count--;
                    carSpeed = 3;
                    carY+=carSpeed;
                } else if (code == KeyCode.A) {
                    if (carX > 30) { // Check if moving left won't go beyond the left boundary
                        carX -= carSpeed + 20;
                        car.setX(carX);
                        checkCollision();
                        check();
                    }
                } else if (code == KeyCode.D) {
                    if (carX + car.getBoundsInParent().getWidth() < scene.getWidth() -20) { // Check if moving right won't go beyond the right boundary
                        carX += carSpeed + 20;
                        car.setX(carX);
                        checkCollision();
                        check();
                    }
                }
                car.setX(carX);
                car.setY(carY);
            }
        });
    }




    void ANIMATION_TIME()
    {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isMovingForward) {
                    carY -= carSpeed;
                    car.setY(carY);
                    checkCollision();
                    check();

                }
            }
        };
        timer.start();
    }

    void check() {
        if (carY < -120) {
            carY = 800;
if(x==1)
{
    stage1.swap(car, carSpeed, carX, carY);
    x=0;
} else if (x==0) {
    root.getChildren().add(car);
    SCORE++;
    END(0);
    x=1;
    stage1.score(SCORE);
}


            // Generate new walls
            MAPING m =new MAPING(root,scene,800,800,stage1);

            m.GENREAT_WALL(1);

        }
    }

    void END(int x)
    {
        if(x==1)
        {

            ImageView YOUWIN=new ImageView(new Image("GAMEOVER.jpg"));
            YOUWIN.setFitHeight(800);
            YOUWIN.setFitWidth(800);
            root.getChildren().add(YOUWIN);

            GAMEOVER();
        }

        if(SCORE ==3)
        {
            ImageView YOUWIN=new ImageView(new Image("yo.jpg"));
            YOUWIN.setFitHeight(800);
            YOUWIN.setFitWidth(800);
            root.getChildren().add(YOUWIN);

            GAMEOVER();

        }

    }

    void GAMEOVER()
    {
        ((Stage) stage1.root1.getScene().getWindow()).close();


        ((Stage) root.getScene().getWindow()).setX(400);
        ((Stage) root.getScene().getWindow()).setY(0);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

       car.setVisible(false);

        executorService.schedule(() -> {

            System.exit(0);

        }, 1, TimeUnit.SECONDS);

    }

    void checkCollision() {
        Bounds carBounds = car.getBoundsInParent();
        for (Node wall : root.getChildren()) {
            if (wall instanceof Rectangle && ((Rectangle) wall).getFill() != null) { // Assuming walls are Rectangle shapes
                if (carBounds.intersects(wall.getBoundsInParent())) {
                    root.getChildren().remove(car); // Remove the car from the scene
                    (stage1.root1).getChildren().remove(car);
                    END(1);
                    GAMEOVER();

                }
            }

        }

    }


    }



package org.example.demo23;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class MAPING  {
    Pane root;
    double WIDTH;
    double Height;
    Random random;
    double wallHeight = 30;
    double wallWidth = 40;
    STAGE stage1;
    Scene scene;

    CAR_THREADS CAR2;

    CAR_USER CAR;


    public MAPING(Pane root, Scene scene, double WIDTH, double Height, STAGE stage1) {
        this.stage1 = stage1;
        this.scene = scene;
        this.root = root;
        this.WIDTH = WIDTH;
        this.Height = Height;
        this.random = new Random();


    }

    public MAPING() {
    }


    void Design() {
        Image image = new Image("Track (2).png");
        ImageView MAP = new ImageView(image);
        MAP.setFitHeight(800);
        MAP.setFitWidth(800);


        root.getChildren().add(MAP);

        this.CAR = new CAR_USER(scene, root, stage1);
        CAR.MAKE_CAR();


        DESIGN_CAR_THREADS();
    }

    void DESIGN_CAR_THREADS() {

        CAR_THREADS CAR1 = new CAR_THREADS(root, scene, 50, 600, stage1);
        Image BLUECAR = new Image("CAR_K.png");
        CAR1.MAKE_CAR(BLUECAR);
        Thread t1 = new Thread(CAR1);

       this.CAR2 = new CAR_THREADS(root, scene, 200, 600, stage1);
        Image YELLOWCAR = new Image("YELLEOW.png");
        CAR2.MAKE_CAR(YELLOWCAR);
        Thread t2 = new Thread(CAR2);

        CAR_THREADS CAR3 = new CAR_THREADS(root, scene, 450, 600, stage1);
        Image GREEN = new Image("CAR_WHITE.png");
        CAR3.MAKE_CAR(GREEN);
        Thread t3 = new Thread(CAR3);

        CAR_THREADS CAR4 = new CAR_THREADS(root, scene, 550, 600, stage1);
        Image GRAY = new Image("gray.png");
        CAR4.MAKE_CAR(GRAY);
        Thread t4 = new Thread(CAR4);

        CAR_THREADS CAR5 = new CAR_THREADS(root, scene, 650, 600, stage1);
        Image PURPLE = new Image("purple.png");
        CAR5.MAKE_CAR(PURPLE);
        Thread t5 = new Thread(CAR5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    void GENREAT_WALL(int NUMBERWALL) {
        for (int i = 0; i < NUMBERWALL; i++) {

            double mapWidth = WIDTH - wallWidth;   // Adjusted map width considering wall's width
            double mapHeight = Height - wallHeight; // Adjusted map height considering wall's height

            double wallX = random.nextDouble() * mapWidth;
            double wallY = random.nextDouble() * mapHeight;

            Rectangle wall = new Rectangle(wallX, wallY, wallWidth, wallHeight);

            root.getChildren().add(new Rectangle(wallX,wallY,wallWidth,wallHeight));
            stage1.root1.getChildren().add(wall);

           
        }

    }




}











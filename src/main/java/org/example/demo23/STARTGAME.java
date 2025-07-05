package org.example.demo23;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class STARTGAME  {
STAGE stage1;
    Pane root;
    Scene scene;
    MAPING mm;
    int chec = 1;
boolean x=false;
    public STARTGAME(Pane root, Scene scene) {
        this.root = root;
        this.scene = scene;
        DESIGn();
    }

    void DESIGn() {

        Image MENU = new Image("MENU.jpg");
        ImageView PHOTO = new ImageView(MENU);
        PHOTO.setFitHeight(800);
        PHOTO.setFitWidth(800);
        root.getChildren().add(PHOTO);
        this.stage1=new STAGE();
        stage1.NEWSTAGE();
       Image image=new Image("TESLA.jpg");

     stage1.DESIGNS(image);
        BOX();


    }


    boolean check()
    {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

while(chec ==1) {
    if (event.getCode() == KeyCode.W) {
         mm =new MAPING(root,scene,800,800,stage1);
        mm.Design();
        Image imag=new Image("TRACK (2).png");
        stage1.DESIGNS(imag);

        x = true;
        chec=0;
        System.out.println(x);

        }
}

            }
        });
        System.out.println(x);
        return x;


    }


    void BOX() {
        Button B = new Button();
        B.setLayoutX(550);
        B.setLayoutY(360);
        B.setText("START");
        B.setScaleX(2.5);
        B.setScaleY(2);
        B.setVisible(false);

        Text text=new Text("click on stage 1 \nENTER W TO START GAME : \nCOMPLET 3 LABS to WIN");
        text.setFont(Font.font(50));
        text.setFill(Color.BLUE);
        text.setY(50);
        text.setX(50);
        root.getChildren().add(B);
        root.getChildren().add(text);
        check();

    }


}

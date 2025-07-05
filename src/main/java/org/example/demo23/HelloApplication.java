package org.example.demo23;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
   public static STARTGAME NEW;
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

       Pane root = new Pane();
         Scene scene = new Scene(root, 770, 800);
        stage.setTitle("CAR RACING");
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setX(-10);
        stage.setY(-10);
        stage.show();
        //////////////////////////////////////////////////////////////////




        //////////////////////////////////////////////
  NEW=new STARTGAME(root, scene);


            stage.show();


    }
public static void SECONDSTAGE(STARTGAME NEW)
{

}


    public static void main(String[] args) {
        launch();
    }
}

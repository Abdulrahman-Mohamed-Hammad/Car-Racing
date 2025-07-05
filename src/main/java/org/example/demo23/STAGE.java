package org.example.demo23;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class STAGE {
    Pane root1;
    Scene scene1;

    public STAGE()
    {

    }
    void NEWSTAGE()
    {
        Stage stage1 =new Stage();
        this.root1 = new Pane();
        this.scene1 = new Scene(root1, 770, 800);
        stage1.setTitle("CAR RACING");
        stage1.getIcons().add(new Image("icon.png"));
        stage1.setScene(scene1);
        stage1.setResizable(false);



        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Calculate the X coordinate for the right corner of the screen
        double rightCornerX = screenBounds.getMaxX() - scene1.getWidth();

        // Set the stage position to the right corner
        stage1.setX(rightCornerX);
        stage1.setY(-10);

        stage1.show();
    }
    void DESIGNS(Image image)
    {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(800);
        //imageView.setRotate(90);
        root1.getChildren().add(imageView);

    }
    void score(int SCORE)
    {
        root1.getChildren().removeIf(node -> node instanceof Text);
        Text score=new Text("LAB "+SCORE);
        score.setFont(Font.font(50));
        score.setX(10);
        score.setY(50);
        score.setFill(Color.BLUE);
        root1.getChildren().add(score);



    }
    void swap(ImageView car,double carSpeed,double carX,double carY)
    {
        root1.getChildren().add(car);

    }
    void swaps(ImageView CAR,double carspeed,double carX,double carY)
    {
        root1.getChildren().add(CAR);
    }
}

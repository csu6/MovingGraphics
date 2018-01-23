package main.java;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PathCircle extends Application {

    private PathTransition pathTransition;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Circle Path");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.GREEN);

        SVGPath svg = new SVGPath();
        svg.setContent("M-200,0a200,200 0 1,0 400,0a200,200 0 1,0 -400,0");
        svg.setLayoutX(350);
        svg.setLayoutY(200);
        svg.setStroke(Color.WHITE);
        svg.setFill(Color.NAVY);
        svg.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //Drawing a object
        Circle circle = new Circle();
        circle.setCenterX(300.0f);
        circle.setCenterY(235.0f);
        circle.setRadius(10.0f);
        circle.setFill(Color.RED);

        //Creating a path transition 1
        pathTransition = new PathTransition();
        pathTransition.setNode(circle);
        pathTransition.setPath(svg);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.setInterpolator(Interpolator.LINEAR); // Pour eviter la pause
        pathTransition.play();

        root.getChildren().add(svg);
        root.getChildren().add(circle);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

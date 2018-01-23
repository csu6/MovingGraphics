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


public class SvgPathTransitionExample extends Application {


    @FXML
    private Button startPauseButton;
    @FXML
    private Button slowerButton;
    @FXML
    private Button fasterButton;

    private PathTransition pathTransition;

    // Contants to control the transition's rate changes
    final double maxRate = 7.0;
    final double minRate = .3;
    final double rateDelta = .3;


    @FXML
    private void slowerAction(ActionEvent event) {
        double currentRate = pathTransition.getRate();
        if( currentRate <=  minRate ) {
            return;
        }
        pathTransition.setRate(currentRate - rateDelta);
        System.out.println("slower rate  = %.2f\n"+ pathTransition.getRate());
    }

    @FXML
    private void fasterAction(ActionEvent event) {
        double currentRate = pathTransition.getRate();
        if( currentRate >= maxRate ) {
            return;
        }

        pathTransition.setRate(currentRate + rateDelta);
        System.out.println("Faster rate = %.2f\n" + pathTransition.getRate());
    }

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start mon programme !!");

        fasterButton = new Button();
        fasterButton.setText("Faster");
        fasterButton.setLayoutX(20);
        fasterButton.setLayoutY(20);
        fasterButton.setOnAction(this::fasterAction);

        slowerButton = new Button();
        slowerButton.setText("Slower");
        slowerButton.setLayoutX(20);
        slowerButton.setLayoutY(50);
        slowerButton.setOnAction(this::slowerAction);


        primaryStage.setTitle("SVGPath");

        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.GREEN);

        // svg 1
        SVGPath svg = new SVGPath();
        //svg.setContent("m1,14.76591113.76591,-13.76591119.46817,0113.76593,13.7659110,19.468171-13.76593,13.76593,13.765931-19.46817,01-13.76591,-13.7659310,-19.46817z");
        svg.setContent("M-200,0a200,200 0 1,0 400,0a200,200 0 1,0 -400,0");
        svg.setLayoutX(350);
        svg.setLayoutY(200);
        svg.setStroke(Color.WHITE);
        svg.setFill(Color.NAVY);
        svg.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT); // Definir le sens de rotation du cercle

        //Drawing a Circle
        Circle circle = new Circle();
        //Setting the position of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);
        //Setting the radius of the circle
        circle.setRadius(10.0f);
        //Setting the color of the circle
        circle.setFill(Color.RED);
        //Setting the stroke width of the circle
        circle.setStrokeWidth(20);

        //Creating a path transition 1
        pathTransition = new PathTransition();
        //Setting the duration of the path transition
        //pathTransition.setDuration(Duration.millis(0));
        //Setting the node for the transition
        pathTransition.setNode(circle);
        //Setting the path
        pathTransition.setPath(svg);
        //Setting the orientation of the path
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //Setting the cycle count for the transition
        pathTransition.setCycleCount(Animation.INDEFINITE);
        //Setting auto reverse value to false
        pathTransition.setAutoReverse(false);
        //pathTransition.setRate(1.0); // Frame per second fps

        pathTransition.setInterpolator(Interpolator.LINEAR); // Pour eviter la pause
        //Playing the animation
        pathTransition.play();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            // TODO do something meaningful here
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        PauseTransition pt1 = new PauseTransition();

        pt1.setDuration(Duration.INDEFINITE);
        pt1.setDuration(Duration.seconds(10));

        // svg 2
        SVGPath svg2 = new SVGPath();
        //svg.setContent("m1,14.76591113.76591,-13.76591119.46817,0113.76593,13.7659110,19.468171-13.76593,13.76593,13.765931-19.46817,01-13.76591,-13.7659310,-19.46817z");
        svg2.setContent("M-150,0a150,150 0 1,0 300,0a150,150 0 1,0 -300,0");
        svg2.setLayoutX(350);
        svg2.setLayoutY(200);
        svg2.setStroke(Color.BLUE);
        svg2.setFill(Color.YELLOW);
        svg2.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT); // Definir le sens de rotation du cercle


        //Drawing a Circle
        Circle circle2 = new Circle();
        //Setting the position of the circle
        circle2.setCenterX(300.0f);
        circle2.setCenterY(135.0f);
        //Setting the radius of the circle
        circle2.setRadius(10.0f);
        //Setting the color of the circle
        circle2.setFill(Color.WHITE);
        //Setting the stroke width of the circle
        circle2.setStrokeWidth(20);


        //Creating a path transition 2
        PathTransition pathTransition2 = new PathTransition();
        //Setting the duration of the path transition
        pathTransition2.setDuration(Duration.millis(5000));
        //Setting the node for the transition
        pathTransition2.setNode(circle2);
        //Setting the path
        pathTransition2.setPath(svg2);
        //Setting the orientation of the path
        pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //Setting the cycle count for the transition
        pathTransition2.setCycleCount(50);
        //Setting auto reverse value to false
        pathTransition2.setAutoReverse(false);
        pathTransition2.setInterpolator(Interpolator.LINEAR); // Pour eviter la pause
        //Playing the animation
        pathTransition2.play();

        root.getChildren().add(svg);
        root.getChildren().add(circle);
        root.getChildren().add(svg2);
        root.getChildren().add(circle2);

        root.getChildren().add(slowerButton);
        root.getChildren().add(fasterButton);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

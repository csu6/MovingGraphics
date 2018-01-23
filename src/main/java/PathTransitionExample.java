import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.scene.shape.*;

import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionExample extends Application {
    @Override
    public void start(Stage stage) {


        //Drawing a Circle
        Circle circle = new Circle();

        //Setting the position of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);

        //Setting the radius of the circle
        circle.setRadius(25.0f);

        //Setting the color of the circle
        circle.setFill(Color.BROWN);

        //Setting the stroke width of the circle
        circle.setStrokeWidth(20);

        //Instantiating the path class
        Path path = new Path();

        //Creating the MoveTo path element
        MoveTo moveTo = new MoveTo(100, 150);

        //Creating the Cubic curve path element
        CubicCurveTo cubicCurveTo = new CubicCurveTo(400, 40, 175, 250, 500, 150);

        //Adding the path elements to Observable list of the Path class
        path.getElements().add(moveTo);
        path.getElements().add(cubicCurveTo);

        //Creating a path transition
        PathTransition pathTransition = new PathTransition();

        //Setting the duration of the path transition
        pathTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        pathTransition.setNode(circle);

        //Setting the path
        pathTransition.setPath(path);

        //Setting the orientation of the path
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        //Setting the cycle count for the transition
        pathTransition.setCycleCount(50);

        //Setting auto reverse value to false
        pathTransition.setAutoReverse(false);

        //Playing the animation
        pathTransition.play();




        SVGPath svg = new SVGPath();
        svg.setContent("m1,14.76591113.76591,-13.76591119.46817,0113.76593,13.7659110,19.468171-13.76593,13.76593,13.765931-19.46817,01-13.76591,-13.7659310,-19.46817z");
        svg.setLayoutX(250);
        svg.setLayoutY(75);
        svg.setStroke(Color.WHITE);
        svg.setFill(Color.NAVY);



        //Creating a Group object
        Group root = new Group(circle);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Path transition example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
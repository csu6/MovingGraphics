
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Transition extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Circle cir = new Circle();
        cir.setFill(Color.RED);
        cir.setRadius(30);
        cir.relocate(50, 50);
        cir.setLayoutX(50);
        cir.setLayoutY(50);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setToX(500);
        transition.setToY(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(cir);
        transition.play();

//        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(3), cir);
//        scaleTransition.setCycleCount(Animation.INDEFINITE);
//        scaleTransition.setAutoReverse(false);
//        scaleTransition.setToX(10);
//        scaleTransition.setToY(10);
//        scaleTransition.play();

        // Rotation
        RotateTransition rt = new RotateTransition(Duration.millis(3000), cir);
        rt.setByAngle(180);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        rt.setNode(cir);
        rt.play();


        Pane root = new Pane();
        root.getChildren().add(cir);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

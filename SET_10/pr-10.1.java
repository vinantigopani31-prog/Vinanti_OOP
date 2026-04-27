import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BouncingBallApp extends Application {

    private double dx = 2; // Horizontal velocity
    private boolean running = false;

    @Override
    public void start(Stage primaryStage) {
        // 1. Create the Ball
        Circle ball = new Circle(20, Color.DODGERBLUE);
        ball.setCenterX(50);
        ball.setCenterY(150);

        // 2. Container for the ball
        Pane canvas = new Pane();
        canvas.setStyle("-border-color: black; -fx-border-width: 2; -fx-background-color: #f4f4f4;");
        canvas.getChildren().add(ball);

        // 3. Controls
        Button startBtn = new Button("Start");
        Button stopBtn = new Button("Stop");
        
        Slider speedSlider = new Slider(1, 10, 2);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        
        Label speedLabel = new Label("Speed:");

        HBox controls = new HBox(15, startBtn, stopBtn, speedLabel, speedSlider);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);

        // 4. Animation Logic
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!running) return;

                // Update speed from slider
                double currentSpeed = speedSlider.getValue();
                
                // Move the ball
                ball.setTranslateX(ball.getTranslateX() + (dx > 0 ? currentSpeed : -currentSpeed));

                // Boundary Check (Right wall)
                if (ball.getCenterX() + ball.getTranslateX() + ball.getRadius() >= canvas.getWidth()) {
                    dx = -1; // Reverse direction
                }
                // Boundary Check (Left wall)
                if (ball.getCenterX() + ball.getTranslateX() - ball.getRadius() <= 0) {
                    dx = 1; // Reverse direction
                }
            }
        };

        // 5. Button Actions
        startBtn.setOnAction(e -> {
            running = true;
            timer.start();
        });

        stopBtn.setOnAction(e -> {
            running = false;
        });

        // 6. Handle Resizing
        // If the window shrinks and the ball is outside the new bounds, 
        // snap it back inside so it doesn't get "lost".
        canvas.widthProperty().addListener((obs, oldVal, newVal) -> {
            double rightEdge = ball.getCenterX() + ball.getTranslateX() + ball.getRadius();
            if (rightEdge > newVal.doubleValue()) {
                ball.setTranslateX(newVal.doubleValue() - ball.getCenterX() - ball.getRadius());
            }
        });

        // Layout setup
        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controls);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("JavaFX Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelImageApp extends Application {
    public void start(Stage stage) {
        Label label = new Label("Welcome to JavaFX");
        ImageView image = new ImageView(new Image("https://openjfx.io/images/javafx.png", true));
        image.setFitWidth(220); image.setPreserveRatio(true);
        stage.setScene(new Scene(new VBox(15, label, image), 400, 300));
        stage.setTitle("Label and Image Demo"); stage.show();
    }
    public static void main(String[] args) { launch(args); }
}

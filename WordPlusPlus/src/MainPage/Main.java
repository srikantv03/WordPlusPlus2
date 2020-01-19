package MainPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = Paths.get("./src/MainPage/wppmain.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("WordPlusPlus");
        primaryStage.setScene(new Scene(root, 960, 640));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

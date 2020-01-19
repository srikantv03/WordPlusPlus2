package MainPage;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextArea editor;
    @FXML
    private WebView browser;
    @FXML
    private JFXTextField namefield;

    String fileName = "NewFile";

    @FXML
    public void onSave() throws IOException {
        String content = testMain.compile(editor.getText());
        String content2 = editor.getText();
        System.out.println(content);
        FileChooser directoryChooser = new FileChooser();
        directoryChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        Stage stage = (Stage) editor.getScene().getWindow();
        File selectedDirectory = directoryChooser.showSaveDialog(stage);
        String path = selectedDirectory.getAbsolutePath();
        String path2 = selectedDirectory.getAbsolutePath().substring(0, selectedDirectory.getAbsolutePath().length()-4) + "Src.txt";

        System.out.println(path);

        try {

            // Java 7
            Files.write(Paths.get(path2), content2.getBytes());
            Files.write(Paths.get(path), content.getBytes());

            // encoding
            // Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));

            // extra options
            // Files.write(Paths.get(path), content.getBytes(),
            //		StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //editor.setHtmlText("<body style='background-color: #4C4C4C; color: white;'/>");
        WebEngine webEngine = browser.getEngine();
        webEngine.load("http://www.google.com");
        editor.setStyle("-fx-text-fill: white;");
    }

    public void onSaveBtn() {
        fileName = namefield.getText();
    }
}

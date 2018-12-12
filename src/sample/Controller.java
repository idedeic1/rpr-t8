package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import java.io.File;

public class Controller {

    public ListView lista;
    public TextField tekst;
    public Button trazi;


    public void onClick(ActionEvent actionEvent) {
        String s = tekst.getText();
        DirectoryChooser dc = new DirectoryChooser();
        dc.setInitialDirectory(new File(System.getProperty("user.home")));
        File f = dc.getInitialDirectory();
        new Thread(() -> {
            for(File file: f.listFiles()){
                if(file.getPath().contains(s)){
                    Platform.runLater(() -> lista.getItems().add(file));
                }
            }
        }).start();
    }


}
package JavaFx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.print.DocFlavor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static controller.controller.findWord;
import static controller.controller.suggestionWord;

public class controllerFx implements Initializable {


    @FXML private TextField textFieldInput;
    @FXML private WebView webView;
    @FXML private WebEngine webEngine;
    @FXML private ListView<String> listView;

    public void actionPerformed(ActionEvent event) throws SQLException {
        showWord();
        ActionEventExit();
    }

    public void showWord() throws SQLException {

        String wordInput = textFieldInput.getText();
        String wordExplain = findWord(wordInput);

        if(wordExplain.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Not found this word");
            alert.setTitle("Information");
            alert.setHeaderText("Notification");
            alert.show();
        }
        else
        {
            webEngine.loadContent(wordExplain);
        }

    }
    public void showList() throws SQLException {
        String input = textFieldInput.getText();
        String word[] = {""};
        word = suggestionWord(input);
        ObservableList<String> data = FXCollections.observableArrayList(word);
        listView.setItems(data);

    }

    public void KeyPress(KeyEvent e) throws SQLException {
        if(e.getCode() == KeyCode.ENTER)
        {
            showWord();
        }

    }

    @FXML
    public void displayMouse(MouseEvent mouseEvent) throws SQLException {
        String text;
        text = listView.getSelectionModel().getSelectedItem();
        textFieldInput.setText(text);

    }

    public void ActionEventExit()
    {
        Platform.exit();
        System.exit(0);
    }


    public void actionEvent(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //webView = new WebView(); k có dong nay
        webEngine = webView.getEngine();
    }
}

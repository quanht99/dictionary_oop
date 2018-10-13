package JavaFx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

import static controller.controller.findWord;
import static controller.controller.suggestionWord;

public class controllerFx {


    @FXML private TextField textFieldInput;
    @FXML private Label labelShowInput;
    @FXML private TextArea textAreashowOutput;
    @FXML private ListView<String> listView;

    public void actionPerformed(ActionEvent event) throws SQLException {
        showWord();
        ActionEventExit();
    }
    public void showWord() throws SQLException {

        labelShowInput.setText(textFieldInput.getText());
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
        textAreashowOutput.setText(wordExplain);
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
    public void displayMouse(MouseEvent mouseEvent)
    {
        String text;
        text = listView.getSelectionModel().getSelectedItem();
        if(text != null && !text.isEmpty())
            textFieldInput.setText(text);
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Not found this word");
            alert.setTitle("Information");
            alert.setHeaderText("Notification");
            alert.show();
        }
    }
    /* Menubar: Menu -> exit*/
    public void ActionEventExit()
    {
        Platform.exit();
        System.exit(0);
    }


    public void actionEvent(MouseEvent mouseEvent) {
    }
}

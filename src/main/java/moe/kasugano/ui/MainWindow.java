package moe.kasugano.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import moe.kasugano.logic.Duke;
import moe.kasugano.logic.DukeException;

public class MainWindow extends AnchorPane {
    @FXML
    private VBox dialogArea;
    @FXML
    private ScrollPane dialogContainer;
    @FXML
    private TextField input;

    int i=0;

    private Duke duke;

    @FXML
    public void initialize(){
        duke = new Duke("data/tasks.txt");
        dialogContainer.vvalueProperty().bind(dialogArea.heightProperty());
    }

    public void onAction() throws Exception{
        dialogArea.getChildren().add(getUserBubble(input.getText()));
        Dialog bot;
        try{
            bot = getBotBubble(duke.execute(input.getText()));
        } catch (DukeException e) {
            bot = getBotBubble(e.getMessage());
        }
        dialogArea.getChildren().add(bot);
    }

    public Dialog getUserBubble(String output) throws Exception{
        Image img = new Image(getClass().getResourceAsStream("/anri.png"));
        Dialog dialog = new Dialog();
        dialog.setContent(img, output);
        dialog.changeSide();
        return dialog;
    }

    public Dialog getBotBubble(String output) throws Exception{
        Image img = new Image(getClass().getResourceAsStream("/anzu.png"));
        Dialog dialog = new Dialog();
        dialog.setContent(img, output);
        return dialog;
    }
}

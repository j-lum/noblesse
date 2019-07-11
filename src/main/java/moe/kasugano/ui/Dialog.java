package moe.kasugano.ui;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import moe.kasugano.Main;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class Dialog extends HBox {
    @FXML
    private ImageView image;
    @FXML
    private Label dialog;

    public Dialog() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Dialog.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    public void setContent(Image img, String text){
        image.setImage(img);
        dialog.setText(text);
    }

    public void changeSide(){
        this.setAlignment(Pos.TOP_RIGHT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.swap(tmp,0,1);
        this.getChildren().setAll(tmp);
    }
}

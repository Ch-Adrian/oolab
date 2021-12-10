package agh.ics.oop.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {

    private Image img;
    private ImageView imgView;
    private Label label;
    private VBox vBox;

    GuiElementBox(Image i, ImageView iV, String pos){
        this.img = i;
        this.imgView = iV;
        iV.setFitHeight(20);
        iV.setFitWidth(20);
        label.setText(pos);
        vBox.getChildren().add(imgView);
        vBox.getChildren().add(label);
        vBox.alignmentProperty().setValue(Pos.CENTER);
    }

}

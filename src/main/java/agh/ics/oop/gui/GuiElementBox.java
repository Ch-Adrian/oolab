package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
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
    private MyVBox myVBox;

    class MyVBox extends VBox{
        private String o;
        @Override
        public String toString() {
            return o;
        }

        public void setO(String o) {
            this.o = o;
        }
    }

    public GuiElementBox(IMapElement e){

        if(e == null){
            this.myVBox = new MyVBox();
            //this.vBox = new VBox();
            //this.vBox.setPrefWidth(20);
            //this.vBox.setPrefHeight(20);
            this.myVBox.setPrefHeight(20);
            this.myVBox.setPrefWidth(20);
            this.myVBox.setO("Empty");
        }
        else {
            this.img = new Image(e.getResource());
            this.imgView = new ImageView(this.img);
            this.imgView.setFitHeight(20);
            this.imgView.setFitWidth(20);
            label = new Label(e.getNamePosition());
            myVBox = new MyVBox();
            myVBox.getChildren().add(imgView);
            myVBox.getChildren().add(label);
            myVBox.alignmentProperty().setValue(Pos.CENTER);
            myVBox.setO(e.getNamePosition());
            /*
            vBox = new VBox();
            vBox.getChildren().add(imgView);
            vBox.getChildren().add(label);
            vBox.alignmentProperty().setValue(Pos.CENTER);
            */

        }
    }

    public VBox getVBox(){
        return this.myVBox;
    }

}

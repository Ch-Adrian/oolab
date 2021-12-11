package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.font.GraphicAttribute;

public class App extends Application implements IPositionChangeObserver{

    private AbstractWorldMap abstractWorldMap;
    private  int h = 4;
    private  int w = 3;
    private GridPane pane;
    private int[] corners;
    private int height;
    private int width;
    private Label[][] labels;
    private VBox[][] graphics;
    private GuiElementBox[][] guiElementBox;
    private VBox vBox;
    private HBox hBox;
    private Button buttonRunEngine;

    private MoveDirection[] moveDirections;
    private IWorldMap map;
    private IEngine engine;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Setting size of map
        corners = abstractWorldMap.findCorner();
        h = corners[3] - corners[1] + 1;
        w = corners[2] - corners[0] + 1;

        //Setting variables
        vBox = new VBox();
        hBox = new HBox();
        pane = new GridPane();
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(30));
        height = h + 1;
        width = w + 1;
        for(int i = 0; i<width; i++){
            pane.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for(int j = 0; j<height; j++){
            pane.getRowConstraints().add(new RowConstraints(50));
        }

        guiElementBox = new GuiElementBox[width][];
        for(int i = 1; i<width; i++){
            guiElementBox[i] = new GuiElementBox[height];
            for(int j = 1; j<height; j++){
                guiElementBox[i][j] = new GuiElementBox((IMapElement) abstractWorldMap.objectAt(new Vector2d(corners[0]+i-1,corners[3] - j + 1)));
                //guiElementBox[i][j] = new GuiElementBox((IMapElement) abstractWorldMap.objectAt(new Vector2d(corners[0]+i-1,corners[1]+j-1)));
            }
        }

        labels = new Label[width][];
        for(int i = 0; i<width; i++){
            labels[i] = new Label[height];
            for(int j = 0; j<height; j++){
                // i columns, j rows
                labels[i][j] = new Label();
                GridPane.setHalignment(labels[i][j], HPos.CENTER);
            }
        }

        // Setting text in first column and first row
        labels[0][0].setText("y\\x");

        for(int i = 1; i<height; i++){
            labels[0][i].setText(String.valueOf(corners[3]-i+1));
        }
        for(int i = 1; i<width; i++){
            labels[i][0].setText(String.valueOf(corners[0]+i-1));
        }

        //Creating button Run engine
        buttonRunEngine = new Button("Run engine");
        buttonRunEngine.setOnAction((ActionEvent event)->{
            runEngine();
        });
        hBox.setPadding(new Insets(0, 10,20,30));
        hBox.getChildren().add(buttonRunEngine);

        vBox.getChildren().add(pane);
        vBox.getChildren().add(hBox);

        setFields();

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setFields(){

        Node o = pane.getChildren().get(0);
        pane.getChildren().clear();
        pane.getChildren().add(o);
        //pane.getChildren().clear();
        //pane.setGridLinesVisible(true);
        // Filling map
        for(int i = 1; i<width; i++){
            for(int j = 1; j<height; j++){
                //graphics[i][j].setText("");
                //Vector2d vec = new Vector2d(corners[0]+i-1,corners[3]-j+1);
                //if(abstractWorldMap.isOccupied(vec)) {
                //graphics[i][j] = guiElementBox[i][j].getVBox();
                    //labels[i][j].setText(abstractWorldMap.objectAt(vec).toString());
                //}
                pane.add(guiElementBox[i][j].getVBox(), i, j);
            }

        }

        for(int i = 1; i<height; i++){
           pane.add(labels[0][i], 0, i);
        }
        for(int i = 1; i<width; i++){
            pane.add(labels[i][0], i, 0);
        }
        pane.add(labels[0][0], 0, 0);


        //System.out.println(pane.getChildren().get(21));
        //System.out.println(pane.getChildren().size());
    }

    @Override
    public void init() throws Exception {
        super.init();

        String[] move = getParameters().getRaw().toArray(new String[0]);
        moveDirections = OptionsParser.parse(move);
        abstractWorldMap = new GrassField(10);
        abstractWorldMap.app = this;
        map = abstractWorldMap;
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 3)};
        engine = new SimulationEngine(moveDirections, map, positions);
    }

    private void runEngine(){

        //pane.getChildren().remove(1,2);
        //engine.run();
        //setFields();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        int i = oldPosition.getX();
        int j = oldPosition.getY();
        guiElementBox[newPosition.getX()-corners[0]+1][newPosition.getY()-corners[1]+1] =  new GuiElementBox((IMapElement) abstractWorldMap.objectAt(new Vector2d(newPosition.getX(),newPosition.getY())));
        guiElementBox[i-corners[0]+1][j-corners[1]+1] = new GuiElementBox((IMapElement) abstractWorldMap.objectAt(new Vector2d(i,j)));
    }
}

package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    private AbstractWorldMap abstractWorldMap;
    private  int h = 4;
    private  int w = 3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Zwierzak");

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(30));

        final int height = h + 1;
        final int width = w + 1;

        Label[][] labels = new Label[width][];
        for(int i = 1; i<width; i++){
            labels[i] = new Label[height];
            for(int j = 1; j<height; j++){
                // i columns, j rows

                labels[i][j] = new Label();
                labels[i][j].setPadding(new Insets(6));
                pane.add(labels[i][j], i, j);
                labels[i][j].setText("Zwierzak");
            }
        }

        labels[0] = new Label[height];
        for(int i = 1; i<width; i++){
            labels[i][0] = new Label(String.valueOf(i));
            labels[i][0].setPadding(new Insets(6));
            pane.add(labels[i][0], i, 0);
        }

        for(int i =1; i<height; i++){
            labels[0][i] = new Label(String.valueOf(height-i));
            labels[0][i].setPadding(new Insets(6));
            pane.add(labels[0][i], 0, i);
        }
        labels[0][0] = new Label("y\\x");
        labels[0][0].setPadding(new Insets(6));
        pane.add(labels[0][0], 0, 0);

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();

        String[] move2 = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] moveDirections = OptionsParser.parse(move2);
        abstractWorldMap = new GrassField(10);
        IWorldMap map2 = abstractWorldMap;
        Vector2d[] positions2 = {new Vector2d(2, 2), new Vector2d(3, 3)};
        IEngine engine2 = new SimulationEngine(moveDirections, map2, positions2);
        System.out.println(map2);
        engine2.run();
        System.out.println(map2);

    }
}
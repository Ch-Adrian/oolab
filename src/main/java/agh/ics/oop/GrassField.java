package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private int n;
    private Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int num){
        this.n = num;
        this.planting();
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) return true;
        if(grasses.get(position) != null){
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object ani = super.objectAt(position);
        if( ani != null) return ani;
        return grasses.get(position);
    }

    private boolean checkPresence(int _x, int _y){
        if(grasses.get(new Vector2d(_x, _y)) != null){
            return true;
        }
        return false;
    }

    private void planting(){
        Random rand = new Random();
        while(grasses.size() < n){
            int a = (int)Math.sqrt(this.n * 10);
            int _x = Math.abs(rand.nextInt())%a;
            int _y = Math.abs(rand.nextInt())%a;
            if( checkPresence(_x, _y) ) continue;
            Grass g = new Grass(new Vector2d(_x, _y));
            grasses.put(new Vector2d(_x, _y), g);
            mapBoundary.addGrass(g);
        }
    }

    public int[] findCorner(){
        int lowest_x = mapBoundary.getFirstX();
        int lowest_y = mapBoundary.getFirstY();
        int highest_x = mapBoundary.getLastX();
        int highest_y = mapBoundary.getLastY();

        int[] arr = {lowest_x, lowest_y, highest_x, highest_y};
        return arr;
    }

}

package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private int n;
    //private ArrayList<Grass> grasses = new ArrayList<>();
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
            grasses.put(new Vector2d(_x, _y), new Grass(new Vector2d(_x, _y)));
        }
    }

    protected int[] findCorner(){
        Vector2d lower = new Vector2d(grasses.get(0).getPosition().x, grasses.get(0).getPosition().y);
        Vector2d higher = new Vector2d(grasses.get(0).getPosition().x, grasses.get(0).getPosition().y);
        int lowest_x = lower.x;
        int lowest_y = lower.y;
        int highest_x = higher.x;
        int highest_y = higher.y;

        for(Grass g: grasses.values()){
            if(g.getPosition().x < lowest_x){
                lowest_x = g.getPosition(). x;
            }
            if(g.getPosition().x > highest_x){
                highest_x = g.getPosition().x;
            }
            if(g.getPosition().y < lowest_y){
                lowest_y = g.getPosition().y;
            }
            if(g.getPosition().y > highest_y){
                highest_y = g.getPosition().y;
            }
        }

        for(Animal g: animals.values()){
            if(g.getPosition().x < lowest_x){
                lowest_x = g.getPosition(). x;
            }
            if(g.getPosition().x > highest_x){
                highest_x = g.getPosition().x;
            }
            if(g.getPosition().y < lowest_y){
                lowest_y = g.getPosition().y;
            }
            if(g.getPosition().y > highest_y){
                highest_y = g.getPosition().y;
            }
        }
        int[] arr = {lowest_x, lowest_y, highest_x, highest_y};
        return arr;
    }

}

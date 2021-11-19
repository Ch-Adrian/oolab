package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private int n;
    private ArrayList<Grass> grasses = new ArrayList<>();

    public GrassField(int num){
        this.n = num;
        this.planting();
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) return true;
        for(Grass g: grasses){
            if( g.getPosition().x == position.x && g.getPosition().y == position.y){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object ani = super.objectAt(position);
        if( ani != null) return ani;
        for(Grass g: grasses){
            if( g.getPosition().x == position.x && g.getPosition().y == position.y){
                return g;
            }
        }
        return null;
    }

    private boolean checkPresence(int _x, int _y){
        for(int i = 0; i<grasses.size(); i++){
            if(grasses.get(i).getPosition().x == _x && grasses.get(i).getPosition().y == _y){
                return true;
            }
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
            grasses.add(new Grass(new Vector2d(_x, _y)));
        }
    }

    protected int[] findCorner(){
        Vector2d lower = new Vector2d(grasses.get(0).getPosition().x, grasses.get(0).getPosition().y);
        Vector2d higher = new Vector2d(grasses.get(0).getPosition().x, grasses.get(0).getPosition().y);
        int lowest_x = lower.x;
        int lowest_y = lower.y;
        int highest_x = higher.x;
        int highest_y = higher.y;

        for(Grass g: grasses){
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

        for(Animal g: animals){
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

    public static void main(String[] args) {
        GrassField grassField = new GrassField(10);
        grassField.place(new Animal(grassField, new Vector2d(1,1)));
        grassField.place(new Animal(grassField, new Vector2d(10,3)));
        grassField.place(new Animal(grassField, new Vector2d(3,-4)));
        grassField.place(new Animal(grassField, new Vector2d(7,-1)));
        grassField.place(new Animal(grassField, new Vector2d(8,15)));
        System.out.println(grassField.toString());

    }

}

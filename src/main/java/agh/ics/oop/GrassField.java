package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField implements IWorldMap{

    private int n;
    private ArrayList<Grass> grasses = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    public GrassField(int num){
        this.n = num;
        this.planting();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for(Animal a: animals){
            if(a.getPosition().x == position.x && a.getPosition().y == position.y){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        for(Animal a: animals){
            if(a.getPosition().x == position.x && a.getPosition().y == position.y){
                return false;
            }
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal a: animals){
            if(a.getPosition().x == position.x && a.getPosition().y == position.y){
                return true;
            }
        }
        for(Grass g: grasses){
            if( g.getPosition().x == position.x && g.getPosition().y == position.y){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a: animals){
            if(a.getPosition().x == position.x && a.getPosition().y == position.y){
                return a;
            }
        }
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

    @Override
    public String toString(){
        MapVisualizer mV = new MapVisualizer(this);
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

        return mV.draw(new Vector2d(lowest_x, lowest_y), new Vector2d(highest_x, highest_y));
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

package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap{

    protected ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position){
        for(Animal ani: animals){
            if(ani.getPosition().x == position.x && ani.getPosition().y == position.y){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition())) { return false; }
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
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a: animals){
            if(a.getPosition().x == position.x && a.getPosition().y == position.y){
                return a;
            }
        }
        return null;
    }

    protected abstract int[] findCorner();

    @Override
    public String toString(){
        MapVisualizer mV = new MapVisualizer(this);
        int[] arr = findCorner();
        return mV.draw(new Vector2d(arr[0], arr[1]), new Vector2d(arr[2], arr[3]));
    }

}

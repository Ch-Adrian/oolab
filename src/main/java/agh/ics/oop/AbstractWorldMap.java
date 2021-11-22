package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{

    //protected ArrayList<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position){
        if(animals.get(position) != null){
            return false;
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition())) { return false; }
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(animals.get(position) != null){
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public void changePosition(Vector2d vecStart, Vector2d vecEnd){
        if(!isOccupied(vecEnd)) {
            Animal a = animals.get(vecStart);
            animals.put(vecEnd, a);
            animals.remove(vecStart);
        }
    }

    protected abstract int[] findCorner();

    @Override
    public String toString(){
        MapVisualizer mV = new MapVisualizer(this);
        int[] arr = findCorner();
        return mV.draw(new Vector2d(arr[0], arr[1]), new Vector2d(arr[2], arr[3]));
    }

}

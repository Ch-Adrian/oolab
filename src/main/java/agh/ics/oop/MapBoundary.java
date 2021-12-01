package agh.ics.oop;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class MapBoundary implements IPositionChangeObserver{

    private class CompX implements Comparator<Vector2d> {

        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if(o1.x < o2.x) return -1;
            else if( o1.x == o2.x){
                if(o1.y < o2.y) {
                    return -1;
                }else if( o1.y == o2.y){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else return 1;
        }
    }

    private class CompY implements  Comparator<Vector2d>{

        @Override
        public int compare(Vector2d o1, Vector2d o2){
            if(o1.y < o2.y) return -1;
            else if( o1.y == o2.y){
                if(o1.x < o2.x) {
                    return -1;
                }else if( o1.x == o2.x){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else return 1;
        }
    }

    private TreeMap<Vector2d, Animal> setX = new TreeMap<>(new CompX());
    private TreeMap<Vector2d, Animal> setY = new TreeMap<>(new CompY());
    private TreeMap<Vector2d, Grass> setXG = new TreeMap<>(new CompX());
    private TreeMap<Vector2d, Grass> setYG = new TreeMap<>(new CompY());

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal a =  setX.get(oldPosition);
        setX.put(newPosition, a);
        setX.remove(oldPosition);

        a = setY.get(oldPosition);
        setY.put(newPosition, a);
        setY.remove(oldPosition);
    }

    public void addAnimal(Animal a){
        setX.put(a.getPosition(), a);
        setY.put(a.getPosition(), a);
    }

    public void addGrass(Grass a){
        setXG.put(a.getPosition(), a);
        setYG.put(a.getPosition(), a);
    }

    public int getFirstX(){
        return Math.min(setX.firstKey().x, setXG.firstKey().x);
    }

    public int getFirstY(){
        return Math.min(setY.firstKey().y, setYG.firstKey().y);
    }

    public int getLastX(){
        return Math.max(setX.lastKey().x, setXG.lastKey().x);
    }

    public int getLastY(){
        return Math.max(setY.lastKey().y, setYG.lastKey().y);
    }

}

package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    private class FieldElement{
        public Animal animal;
        public Grass grass;

        FieldElement(Animal a){
            animal = a;
        }

        FieldElement(Grass g){
            grass = g;
        }

    }

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

    private TreeMap<Vector2d, FieldElement> setX = new TreeMap<>(new CompX());
    private TreeMap<Vector2d, FieldElement> setY = new TreeMap<>(new CompY());


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        FieldElement fieldElement = setX.get(oldPosition);
        FieldElement fieldElement2;

        if(setX.containsKey(newPosition)) {
            fieldElement2 = setX.get(newPosition);
            fieldElement2.animal = fieldElement.animal;
        }
        else{
            fieldElement2 = new FieldElement(fieldElement.animal);
            setX.put(newPosition, fieldElement2);
        }
        fieldElement.animal = null;

        fieldElement = setY.get(oldPosition);

        if(setY.containsKey(newPosition)) {
            fieldElement2 = setY.get(newPosition);
            fieldElement2.animal = fieldElement.animal;
        }
        else{
            fieldElement2 = new FieldElement(fieldElement.animal);
            setY.put(newPosition, fieldElement2);
        }
        fieldElement.animal = null;
    }

    public void addAnimal(Animal a){
        FieldElement fieldElement;
        if(setX.containsKey(a.getPosition())){
            fieldElement = setX.get(a.getPosition());
            fieldElement.animal = a;
        }
        else{
            fieldElement = new FieldElement(a);
            setX.put(a.getPosition(), fieldElement);
        }

        if(setY.containsKey(a.getPosition())){
            fieldElement = setY.get(a.getPosition());
            fieldElement.animal = a;
        }
        else{
            fieldElement = new FieldElement(a);
            setY.put(a.getPosition(), fieldElement);
        }
    }

    public void addGrass(Grass a){
        FieldElement fieldElement;
        if(setX.containsKey(a.getPosition())){
            fieldElement = setX.get(a.getPosition());
            fieldElement.grass = a;
        }
        else{
            fieldElement = new FieldElement(a);
            setX.put(a.getPosition(), fieldElement);
        }

        if(setY.containsKey(a.getPosition())){
            fieldElement = setY.get(a.getPosition());
            fieldElement.grass = a;
        }
        else{
            fieldElement = new FieldElement(a);
            setY.put(a.getPosition(), fieldElement);
        }
    }

    public int getFirstX(){
        return setX.firstKey().x;
    }

    public int getFirstY(){
        return setY.firstKey().y;
    }

    public int getLastX(){
        return setX.lastKey().x;
    }

    public int getLastY(){
        return setY.lastKey().y;
    }

}

package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private int width;
    private int height;

    private ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        if(width >=1 ) {
            this.width = width;
        } else {
            this.width = 5;
        }

        if(height >= 1){
            this.height = height;
        }
        else{
            this.height = 5;
        }

    }

    private boolean isInside(Vector2d position){
        if(position.x >= 0 && position.y >= 0 && position.x < this.width && position.y < this.height) return true;
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(isInside(position)){
            for(Animal ani: animals){
                if(ani.getPosition().x == position.x && ani.getPosition().y == position.y){
                    return false;
                }
            }
            return true;
        }
        else return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(isInside(position)){
            for(Animal ani: animals){
                if(ani.getPosition().x == position.x && ani.getPosition().y == position.y){
                    return true;
                }
            }
            return false;
        }
        else return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(isInside(position)){
            for(Animal ani: animals){
                if(ani.getPosition().x == position.x && ani.getPosition().y == position.y){
                    return ani;
                }
            }
        }
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer mV = new MapVisualizer(this);
        return mV.draw(new Vector2d(0,0), new Vector2d(this.width - 1,this.height-1));
    }

    public static void main(String[] args) {
        RectangularMap rectangularMap = new RectangularMap(5,5);
        rectangularMap.place(new Animal(rectangularMap));
        rectangularMap.place(new Animal(rectangularMap));
        rectangularMap.place(new Animal(rectangularMap, new Vector2d(0,0)));
        rectangularMap.place(new Animal(rectangularMap, new Vector2d(1,4)));
        System.out.println(rectangularMap.toString());
    }

}

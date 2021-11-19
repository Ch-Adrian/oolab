package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private int width;
    private int height;

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
        if (!isInside(position)) {
            return false;
        }
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!isInside(animal.getPosition())){ return false; }
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(!isInside(position)){ return false; }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(!isInside(position)){ return null; }
        return super.objectAt(position);
    }

    protected int[] findCorner(){
        int[] arr = {0, 0, this.width - 1, this.height - 1};
        return arr;
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

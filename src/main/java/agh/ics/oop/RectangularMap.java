package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private int width;
    private int height;

    Animal[][] map;

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

        map = new Animal[this.width][this.height];
        for(int i = 0; i<this.width; i++){
            for(int j = 0; j<this.height; j++){
                map[i][j] = null;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        refresh();
        if(position.x >= 0 && position.y >= 0 && position.x < this.width && position.y < this.height && (map[position.x][position.y] == null)) return true;
        else return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            map[animal.getPosition().x][animal.getPosition().y] = animal;
            return true;
        }
        return false;
    }

    public boolean erase(Animal animal){
        if(isOccupied(animal.getPosition())){
            if(map[animal.getPosition().x][animal.getPosition().y].equals(animal)){
                map[animal.getPosition().x][animal.getPosition().y] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        refresh();
        if(position.x >= 0 && position.y >= 0 && position.x < this.width && position.y < this.height && (map[position.x][position.y] != null)) return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        refresh();
        if(position.x >= 0 && position.y >= 0 && position.x < this.width && position.y < this.height){
            return map[position.x][position.y];
        }
        return null;
    }

    private void refresh(){

        ArrayList<Animal> aAnimal = new ArrayList<>();

        for(int i = 0; i< width; i++){
            for(int j = 0; j< height; j++){
                if( map[i][j] != null){
                    aAnimal.add(map[i][j]);
                }
                map[i][j] = null;
            }
        }
        for(int i = 0; i<aAnimal.size(); i++){
            this.place(aAnimal.get(i));
        }

    }

    @Override
    public String toString(){
        refresh();
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

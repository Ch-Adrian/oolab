package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map = null;
    private List<IPositionChangeObserver> observerList = new ArrayList<>();

    public Animal(){

    }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(IWorldMap map, Vector2d initialPosition, MapDirection mD){
        this.map = map;
        this.position = initialPosition;
        this.orientation = mD;
    }

    public String getResource(){
        StringBuilder stringBuilder = new StringBuilder();
        switch(orientation){
            case NORTH -> stringBuilder.append("file:src/main/resources/up.png");
            case EAST -> stringBuilder.append("file:src/main/resources/right.png");
            case WEST -> stringBuilder.append("file:src/main/resources/left.png");
            case SOUTH -> stringBuilder.append("file:src/main/resources/down.png");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getNamePosition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Z ");
        stringBuilder.append("(");
        stringBuilder.append(this.position.x);
        stringBuilder.append(",");
        stringBuilder.append(this.position.y);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    boolean isAt(Vector2d position){
        if(this.position.x == position.x && this.position.y == position.y){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        switch(orientation){
            case NORTH -> stringBuilder.append("N");
            case EAST -> stringBuilder.append("E");
            case WEST -> stringBuilder.append("W");
            case SOUTH -> stringBuilder.append("S");
        }
        return stringBuilder.toString();
    }

    private boolean isInside(Vector2d pos){
        return pos.precedes(new Vector2d(4,4)) && pos.follows(new Vector2d(0,0));
    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if( map == null ){
                    if (isInside(position.add(orientation.toUnitVector()))) {
                        positionChanged(position, position.add(orientation.toUnitVector()));
                        position = position.add(orientation.toUnitVector());
                    }
                }else {
                    if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                        positionChanged(position, position.add(orientation.toUnitVector()));
                        position = position.add(orientation.toUnitVector());
                    }
                }
            }
            case BACKWARD -> {
                if( map == null ){
                    if (isInside(position.subtract(orientation.toUnitVector()))) {
                        positionChanged(position, position.subtract(orientation.toUnitVector()));
                        position = position.subtract(orientation.toUnitVector());
                    }
                }else {
                    if (map.canMoveTo(position.subtract(orientation.toUnitVector()))){
                        positionChanged(position, position.subtract(orientation.toUnitVector()));
                        position = position.subtract(orientation.toUnitVector());
                    }

                }
            }
        }
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        //System.out.println(Thread.currentThread().getName());
        for(IPositionChangeObserver observer: observerList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public Vector2d getPosition(){
        return position;
    }

    public void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }

}

package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map = null;

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
                        position = position.subtract(orientation.toUnitVector());
                    }
                }else {
                    if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                        position = position.add(orientation.toUnitVector());
                    }
                }
            }
            case BACKWARD -> {
                if( map == null ){
                    if (isInside(position.subtract(orientation.toUnitVector()))) {
                        position = position.subtract(orientation.toUnitVector());
                    }
                }else {
                    if (map.canMoveTo(position.subtract(orientation.toUnitVector()))){
                        position = position.subtract(orientation.toUnitVector());
                    }

                }
            }
        }
    }

    public Vector2d getPosition(){
        return position;
    }


}

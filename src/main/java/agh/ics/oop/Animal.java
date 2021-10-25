package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position: ");
        stringBuilder.append(position.toString());
        stringBuilder.append(" Orientation: ");
        stringBuilder.append(orientation.toString());
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
                if(isInside(position.add(orientation.toUnitVector())))
                {
                    position = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if( isInside(position.subtract(orientation.toUnitVector()))){
                    position = position.subtract(orientation.toUnitVector());
                }
            }
        }
    }


}

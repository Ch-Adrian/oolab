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


}

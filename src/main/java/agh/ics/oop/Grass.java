package agh.ics.oop;

public class Grass implements IMapElement{

    private Vector2d pos;

    public Grass(Vector2d position){
        this.pos = position;
    }

    public Vector2d getPosition(){
        return pos;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*");
        return stringBuilder.toString();
    }

    public String getResource(){
        return "file:src/main/resources/grass.png";
    }

    public String getNamePosition(){
        return "Trawa";
    }

}

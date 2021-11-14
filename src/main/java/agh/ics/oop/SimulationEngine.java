package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{

    private static ArrayList<Animal> arrayAni = new ArrayList<>();

    public IWorldMap map;
    MoveDirection[] moveDirections;

    public SimulationEngine(MoveDirection[] tab, IWorldMap map, Vector2d[] vecTab){
        for(MoveDirection dir:tab){
            System.out.println(dir);
        }
        this.map = map;
        this.moveDirections = tab;
        for(int i = 0; i<vecTab.length; i++){
            if(!map.isOccupied(vecTab[i])){
                Animal a = new Animal(map, vecTab[i]);
                arrayAni.add(a);
                map.place(a);
            }
        }
    }

    @Override
    public void run() {

        for(int i = 0; i<moveDirections.length; i++){
            Animal inst = arrayAni.get(i % arrayAni.size());
            switch(moveDirections[i]) {
                case BACKWARD -> inst.move(MoveDirection.BACKWARD);
                case FORWARD -> inst.move(MoveDirection.FORWARD);
                case LEFT -> inst.move(MoveDirection.LEFT);
                case RIGHT -> inst.move(MoveDirection.RIGHT);
            }

        }

    }

}

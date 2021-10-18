package agh.ics.oop;

import java.util.Vector;

public class Vector2d {

    final int x;
    final int y;

    Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }

    boolean precedes(Vector2d other){
        if( this.x <= other.x && this.y <= other.y){
            return true;
        }
        else { return false; }
    }

    boolean follows(Vector2d other){
        if( this.x >= other.x && this.y >= other.y){
            return true;
        }
        else { return false; }
    }

    Vector2d upperRight(Vector2d other){
        return new Vector2d(this.x > other.x ? this.x : other.x, this.y > other.y ? this.y : other.y );
    }

    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(this.x < other.x ? this.x : other.x, this.y < other.y ? this.y : other.y);
    }

    Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.y, this.y - other.y);
    }

    public boolean equals(Object other){
        if( other instanceof Vector2d) {
            return this.x == ((Vector2d) other).x && this.y == ((Vector2d) other).y;
        }
        else{
            return false;
        }
    }
    Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }


}

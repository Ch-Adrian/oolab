package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start systemu");

        run(new String[]{"1", "2", "3"});

        System.out.println("Koniec systemu");
    }

    public static void run(String[] arr){
        System.out.println("Zwierzak idzie do przodu");
        for(String str: arr){
            System.out.print(str + ", ");
        }
    }

}

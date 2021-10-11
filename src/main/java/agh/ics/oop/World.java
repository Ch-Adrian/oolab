package agh.ics.oop;

public class World {
    @SuppressWarnings("EnhancedSwitchMigration")
    public static void main(String[] args) {
        System.out.println("Start");
        //run(new String[]{"1", "2", "3"});

        for(String dir: args){
            switch(dir){
                case "f":
                    System.out.println("Zwierzak idzie do przodu.");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:

            }
        }

        System.out.println("Stop");
    }

    public static void run(String[] arr){
        System.out.println("Zwierzak idzie do przodu");

        int cnt = 0;
        for(String str: arr){
            System.out.print(str);
            if(cnt != arr.length - 1){
                System.out.print(", ");
            }
            cnt++;
        }
        System.out.println();
    }

}

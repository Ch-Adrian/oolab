package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("Start systemu");
        System.out.println(args.length);
        run(new String[]{"1", "2", "3"});

        System.out.println("Koniec systemu");
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

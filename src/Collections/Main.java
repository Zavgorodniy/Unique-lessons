package Collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with main() method for testing classes
 */
public class Main {

    public static void main(String[] args) {

        MapM myMap = new MapM();

        Object o1 = new Object();
        Object o2 = new Object();

        myMap.add("1", 1);
        myMap.add(43.5, null);
        myMap.add(1, 124);
        myMap.add("5", 124);
        myMap.add('5', 2);
        myMap.add("k", "value");
        myMap.add('k', "value");

        System.out.println(myMap.toString());
//
//        myMap.add('5', 1);
//
//        System.out.println(myMap.toString());
//
//        myMap.add(1, 18);
//
//        myMap.remove("1");
//
//        System.out.println(myMap.toString());
//
//        System.out.println(myMap.get(43.5));

        myMap.reverse();


        System.out.println(myMap.toString());

//        System.out.println(myMap.min());
    }
}

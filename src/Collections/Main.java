package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class with main() method for testing classes
 */
public class Main {

    public static void main(String[] args) {

        boolean correctInsert = false;
        Scanner in = new Scanner(System.in);
        int choice = 1;
        int size = 20;
        Object key;
        Object value;
        MapM myMap = new MapM();

        while (!correctInsert) {
            System.out.println("Choose method for filling collection\n" +
                    "1 - fill manual\n" +
                    "2 - fill automatical\n");

            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice == 2) {
                    for (int i = 0; i < size; i++) {
                        myMap.add(i, (int) (Math.random() * 100));
                    }
                    correctInsert = true;
                    continue;
                } else if (choice == 1){
                    System.out.println("Enter number of elements to insert:\n");
                    correctInsert = true;
                    continue;
                }
            }

            System.out.println("Incorrect input");
        }

        correctInsert = false;

        if (choice == 1) {

            while(!correctInsert) {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    if(choice > 0) {
                        size = choice;
                        correctInsert = true;
                        continue;
                    }
                }
                System.out.println("Incorrect input");
            }

            for (int i = 0; i < size; i++) {
                key = null;
                System.out.println("Insert key of pair");
                if (in.hasNextInt()) {
                    key = in.nextInt();
                    continue;
                }
                if (in.hasNextDouble()) {
                    key = in.nextDouble();
                    continue;
                }
                if (in.hasNext()) {
                    key = in.next();
                    continue;
                }
                System.out.println("Insert value of pair");
                if (in.hasNextInt()) {
                    myMap.add(key, in.nextInt());
                    continue;
                }
                if (in.hasNextDouble()) {
                    myMap.add(i, in.nextDouble());
                    continue;
                }
                if (in.hasNext()) {
                    myMap.add(i, in.next());
                    continue;
                }
            }
        }

        correctInsert = false;

        while (true) {
            System.out.println("Please choose operation: ");
            System.out.println("1 - add element");
            System.out.println("2 - get element");
            System.out.println("3 - remove element");
            System.out.println("4 - sort collection");
            System.out.println("5 - reverse collection");
            System.out.println("6 - find min");
            System.out.println("7 - find max");
            System.out.println("8 - return number of elements in collection");
            System.out.println("9 - print collection");

            choice = in.nextInt();

//            while(!correctInsert) {
//                if (in.hasNextInt()) {
//                    choice = in.nextInt();
//                    if (0 < choice && choice < 10) {
//                        correctInsert = true;
//                        continue;
//                    }
//                }
//                System.out.println("Incorrect input");
//            }

            switch (choice) {
                case 1:
                    System.out.println("Enter key\n");
                    key = "null";
                    if (in.hasNextInt())
                        key = in.nextInt();
                    else if (in.hasNextDouble())
                        key = in.nextDouble();
                    else if (in.hasNext())
                        key = in.next();

                    System.out.println("Enter value\n");
                    value = "null";
                    if (in.hasNextInt())
                        value = in.nextInt();
                    else if (in.hasNextDouble())
                        value = in.nextDouble();
                    else if (in.hasNext())
                        value = in.next();

                    myMap.add(key, value);
                    break;
                case 2:
                    System.out.println("Enter key\n");
                    key = "null";
                    if (in.hasNextInt()) {
                        key = in.nextInt();
                        myMap.get(key);
                        break;
                    }
                    if (in.hasNextDouble()) {
                        key = in.nextDouble();
                        myMap.get(key);
                        break;
                    }
                    if (in.hasNext()) {
                        key = in.next();
                        myMap.get(key);
                        break;
                    }
                case 3:
                    System.out.println("Enter key\n");
                    key = in.next();
                    myMap.remove(key);
                    break;
                case 4:
                    myMap.sort(true);
                    break;
                case 5:
                    myMap.reverse();
                    break;
                case 6:
                    myMap.min();
                    break;
                case 7:
                    myMap.max();
                    break;
                case 8:
                    myMap.size();
                    break;
                case 9:
                    System.out.println(myMap.toString());
                    break;
            }
        }
//        Object key = in.next();
//        Object value = in.next();
//        myMap.add(key, value);
//
//        myMap.size();
//        myMap.add("key", "value");
//        myMap.size();
//        myMap.add("key", 1234);
//        myMap.size();
//
//        System.out.println(myMap.get("key"));
//        System.out.println(myMap.get(null));
//        System.out.println(myMap.get(1));
//
//        for (int i = 0; i < 16; i++) {
//            myMap.add(i, i + 10);
//        }

//        myMap.add(43.5, null);
//        myMap.add(1, 124);
//        myMap.add("5", 124);
//        myMap.add('5', 2);
//        myMap.add("k", "value");
//        myMap.add('k', "value");
//
//        Object o1 = new Object();
//        Object o2 = new Object();

//        System.out.println(myMap.toString());
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

//        myMap.reverse();
//
//
//        System.out.println(myMap.toString());

//        System.out.println(myMap.min());
    }
}

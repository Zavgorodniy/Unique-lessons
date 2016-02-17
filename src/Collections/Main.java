package Collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class with main() method for testing classes
 */
public class Main {

    public static void main(String[] args) {

        ArrayListM myList = new ArrayListM();

        System.out.println(myList.size);

        for (int i = 0; i < 23; i++) {
            myList.add(i);
        }

        myList.set(22, 3);

        myList.add(4.45);

        System.out.println(myList.toString());

        myList.sort(true);

        System.out.println(myList.toString());

    }
}

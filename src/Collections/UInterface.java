package Collections;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UInterface {
    private static MapM myMap = new MapM();
    private static int size = 20;

    public static void dialog() {
        fillingDialog();
        operationsDialog();
    }

    private static int checkChoiceDialog(String regEx) {
        Pattern p = Pattern.compile(regEx);
        Scanner in = new Scanner(System.in);
        String enter = "";
        boolean correctInsert = false;

        while (!correctInsert) {
            enter = in.next();
            Matcher m = p.matcher(enter);
            correctInsert = m.matches();
            if (correctInsert)
                continue;
            System.out.println("Incorrect input! Try again.");
        }

        return Integer.parseInt(enter);
    }

    private static void fillingDialog() {
        String enteredData;
        Scanner in = new Scanner(System.in);
        Object key;
        Object value;
        int choice;

        System.out.println("Choose method for filling collection\n" +
                "1 - manual filling\n" +
                "2 - auto filling\n");

        choice = checkChoiceDialog("^[1|2]$");

        if (choice == 1) {
            System.out.println("Enter number of elements to insert(max 20):\n");
            size = checkChoiceDialog("^[1-9]|([1][0-9])|[2][0]$");
            for (int i = 0; i < size; i++)
                manualAdd();
        }
        else {
            for (int i = 0; i < size; i++)
                myMap.add(i, (int) (Math.random() * 100));
        }
    }

    private static void manualAdd() {
        String enteredData;
        Scanner in = new Scanner(System.in);
        Object key;
        Object value;
        Class type;

        System.out.println("Insert key of pair");

        enteredData = in.next();
        type = typeAnalize(enteredData);

        if(type.equals(Integer.class))
            key = Integer.parseInt(enteredData);
        else if(type.equals(Character.class))
            key = enteredData.charAt(0);
        else if(type.equals(Double.class))
            key = Double.parseDouble(enteredData);
        else
            key = enteredData;

        System.out.println("Insert value of pair");

        enteredData = in.next();
        type = typeAnalize(enteredData);

        if(type.equals(Integer.class))
            value = Integer.parseInt(enteredData);
        else if(type.equals(Character.class))
            value = enteredData.charAt(0);
        else if(type.equals(Double.class))
            value = Double.parseDouble(enteredData);
        else
            value = enteredData;

        myMap.add(key, value);
    }

    private static Class typeAnalize(String stringToAnalize) {
        if (Pattern.compile("^-?[0-9]|-?[1-9][0-9]{1,8}$").matcher(stringToAnalize).matches())
            return Integer.class;
        else if (Pattern.compile("^.$").matcher(stringToAnalize).matches())
            return Character.class;
        else if (Pattern.compile("^[0-9]+\\.[0-9]*$").matcher(stringToAnalize).matches())
            return Double.class;
        return String.class;
    }

    private static void operationsDialog() {
        String enteredData;
        Scanner in = new Scanner(System.in);
        Object key;
        int choice = 1;
        Class type;
        boolean exit = false;

        while (choice == 1) {
            System.out.println("Please choose operation:\n" +
                            "1 - add element\n" +
                            "2 - get element\n" +
                            "3 - remove element\n" +
                            "4 - sort collection\n" +
                            "5 - reverse collection\n" +
                            "6 - find min\n" +
                            "7 - find max\n" +
                            "8 - return number of elements in collection\n" +
                            "9 - print collection\n");

            choice = checkChoiceDialog("^[1-9]$");

            try {
                switch (choice) {
                    case 1:
                        manualAdd();
                        break;
                    case 2:
                        System.out.println("Enter key\n");
                        enteredData = in.next();
                        type = typeAnalize(enteredData);
                        if (type.equals(Integer.class))
                            key = Integer.parseInt(enteredData);
                        else if (type.equals(Character.class))
                            key = enteredData.charAt(0);
                        else if (type.equals(Double.class))
                            key = Double.parseDouble(enteredData);
                        else
                            key = enteredData;

                        myMap.get(key);
                        break;
                    case 3:
                        System.out.println("Enter key\n");
                        enteredData = in.next();
                        type = typeAnalize(enteredData);
                        if (type.equals(Integer.class))
                            key = Integer.parseInt(enteredData);
                        else if (type.equals(Character.class))
                            key = enteredData.charAt(0);
                        else if (type.equals(Double.class))
                            key = Double.parseDouble(enteredData);
                        else
                            key = enteredData;

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
                        System.out.println(myMap.size());
                        break;
                    case 9:
                        System.out.println(myMap.toString());
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                operationsDialog();
            }

            System.out.println("Another operation?\n" +
                    "1 - Yes\n" +
                    "2 - No");

            choice = checkChoiceDialog("^[1|2]$");
        }
    }
}
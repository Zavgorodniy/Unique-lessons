package Math;

import java.util.ArrayList;

public class Matrix {

    int[][][] matrix;
    int size = 5;

    Matrix (int size) {
        this.size = size;
        matrix = new int[size][size][size];
    }

    public void generate() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {

                    matrix[i][j][k] = (int) (Math.random()*100);
                }
            }
        }
    }

    public static void generateList() {

        int size = 5;
        ArrayList<ArrayList<ArrayList>> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(new ArrayList());

            for (int j = 0; j < size; j++) {
                list.get(i).add(new ArrayList());

                for (int k = 0; k < size; k++) {
                    list.get(i).get(j).add((int) (Math.random()*100));
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.print(list.get(i).get(j).get(k) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.print(matrix[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

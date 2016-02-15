package Math;

public class Mathem {

    public void factorial(int n) {
        long fact = 1;
        long factMax = 1;

        for (int j = 1; j <= n; j++) fact *= j;

        int i = 1;
        while (factMax > 0) factMax *= ++i;

        System.out.println("Max factorial num: " + --i);
        System.out.println(n + "! = " + fact);
    }

    public void sqrt(int num) {
        int i = num/2;
        int iteration = 0;

        while (num < i * i) {
            i /= 2;
            iteration++;
        }
        while (num > i * i) {
            i++;
            iteration++;
        }
        System.out.println("Iteration count: " + iteration);
        System.out.printf("sqrt(%d) = %d", num, i);
    }
}

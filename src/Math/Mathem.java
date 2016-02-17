package Math;

/** Class, that contains mathematical functions
 * @author Nick
 * @version 1.0 beta Feb, 2016.
 * @deprecated due to
 * @see Mathem#factorial(int)
 * @since 1.0
 */
public class Mathem {

    /**
    *{@value}
    */
    public static final int i = 1;

    /**
     * Function that finds factorial of inserted value
     * @param n int value
     * @return !n
     */
    public long factorial(int n) {
        long fact = 1;
        long factMax = 1;

        for (int j = 1; j <= n; j++) fact *= j;

        int i = 1;
        while (factMax > 0) factMax *= ++i;

        System.out.println("Max factorial num: " + --i);
        System.out.println(n + "! = " + fact);
        return fact;
    }

    /**
     * Function that finds sqrt of inserted value
     * @param num int value
     */
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

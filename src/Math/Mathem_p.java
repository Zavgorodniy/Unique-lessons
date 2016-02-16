package Math;

/** Class, that contains mathematical functions
 *
 * @author <b>Nick</b> Zavgorodniy
 * @version 1.0 beta Feb, 2016.
 * @deprecated
 * @see Mathem_a_p
 * @since JDK 1.0
 */
public class Mathem_p extends Mathem {

    public void sqrt(int num, int power) {
        int checkNum = num/2;
        int iteration = 0;

        int condition = 1;
        for (int j = 1; j <= power; j++)
            condition*= checkNum;

        while (num < condition) {
            checkNum = checkNum/2;
            condition = 1;
            for (int j = 1; j <= power; j++)
                condition*= checkNum;
            iteration++;
        }

        while (num > condition) {
            checkNum++;
            condition = 1;
            for (int j = 1; j <= power; j++)
                condition*= checkNum;
            iteration++;
        }

        System.out.println("Iteration count: " + iteration);
        System.out.printf("sqrt(%d) power %d = %d", num, power, checkNum);
    }
}

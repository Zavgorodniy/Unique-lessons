package Math;


/** Class, that contains mathematical functions
 * @see DataBase.MainDataBase contain
 * @author Nick
 * @version 1.0 beta Feb, 2016.
 * @since JDK 1.0
 */
public class Mathem_a_p extends Mathem_p {

    public void sqrt(int num, int power, int accuracy) {
        double checkNum = num / (power * power);
        int iteration = 0;
        double acc = 1;

        while (num < java.lang.Math.pow(checkNum, power)) {
            checkNum = checkNum/2;
            iteration++;
        }

        for (int i = 0; i < accuracy; i++) {
            acc /= 10;

            while (num > java.lang.Math.pow(checkNum, power)) {
                checkNum += acc;
                iteration++;
            }

            while (num < java.lang.Math.pow(checkNum, power)) {
                checkNum -= acc;
                iteration++;
            }
        }

        System.out.println("Iteration count: " + iteration);
        System.out.print(checkNum);
    }
}

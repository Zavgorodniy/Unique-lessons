package Math;

public class Mathem_a_p extends Mathem_p {

    public void sqrt(int num, int power, int accuracy) {
        double checkNum = num / (accuracy * accuracy);
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

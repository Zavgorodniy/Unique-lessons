package Math;

public class Converter {

    public static void bitToDec(String bit) {
        int num = 0;
        int pow = 0;

        for (int i = bit.length() - 1; i >= 0; i--) {
            num += Character.getNumericValue(bit.charAt(i)) * Math.pow(2, pow);
            pow++;
        }

        System.out.print(num);
    }

    public static void hexToDec(String hex) {
        int num = 0;
        int pow = 0;

        for (int i = hex.length() - 1; i >= 0; i--) {
            num += Character.getNumericValue(hex.charAt(i)) * Math.pow(16, pow);
            pow++;
        }

        System.out.print(num);
    }

    public static void decToBit(int dec) {
        StringBuilder num = new StringBuilder();

        while (dec != 0) {
            num.append(dec % 2);
            dec /= 2;
        }

        System.out.print(num.reverse());
    }

    public static void decToHex(int dec) {
        StringBuilder num = new StringBuilder();

        while (dec != 0) {
            int buf = dec % 16;

            if (buf < 10) {
                num.append(buf);
            } else {
                num.append((char) (buf + 55));
            }

            dec /= 16;
        }

        System.out.print(num.reverse());
    }

    public static void hexToBit(String hex) {
        StringBuilder num = new StringBuilder();
        StringBuilder digitBit = new StringBuilder();

        for (int i = 0; i < hex.length(); i++) {
            int digitHex = Character.getNumericValue(hex.charAt(i));

            for (int j = 0; j < 4; j++) {
                digitBit.append(digitHex % 2);
                digitHex /= 2;
            }

            num.append(digitBit.reverse());
            digitBit.setLength(0);
        }

        System.out.print(num);
    }

    public static void bitToHex(String bit) {
        StringBuilder num = new StringBuilder();
        int i = bit.length();
        int buf = 0;
        int pow = 0;

        while (--i >= 0) {
            buf += Character.getNumericValue(bit.charAt(i)) * Math.pow(2, pow);
            if (++pow == 4 | i == 0) {
                if (buf < 10) {
                    num.append(buf);
                } else {
                    num.append((char) (buf + 55));
                }

                pow = 0;
                buf = 0;
            }
        }

        System.out.print(num.reverse());
    }
}

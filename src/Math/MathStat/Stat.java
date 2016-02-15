package Math.MathStat;

import java.util.ArrayList;

public class Stat{

    public static void min(Gen gen) {
        ArrayList array = gen.getArray();
        Gen.Type type = gen.getType();

        switch (type) {
            case BYTE:
                byte minByte = (byte) array.get(0);
                byte elByte;

                for (int i = 1; i < array.size(); i++) {
                    elByte = (byte) array.get(i);
                    if(elByte < minByte)
                        minByte = elByte;
                }

                System.out.println("min element = " + minByte);
                break;

            case SHORT:
                short minShort = (short) array.get(0);
                short elShort;

                for (int i = 1; i < array.size(); i++) {
                    elShort = (short) array.get(i);
                    if(elShort < minShort)
                        minShort = elShort;
                }

                System.out.println("min element = " + minShort);
                break;

            case INT:
                int minInt = (int) array.get(0);
                int el;

                for (int i = 1; i < array.size(); i++) {
                    el = (int) array.get(i);
                    if(el < minInt)
                    minInt= el;
                }

                System.out.println("min element = " + minInt);
                break;

            case FLOAT:
                float minFl = (float) array.get(0);
                float elFl;

                for (int i = 1; i < array.size(); i++) {
                    elFl = (float) array.get(i);
                    if(elFl < minFl)
                        minFl = elFl;
                }

                System.out.println("min element = " + minFl);
                break;

            case CHAR:
                char minCh = (char) array.get(0);
                char elCh;

                for (int i = 1; i < array.size(); i++) {
                    elCh = (char) array.get(i);
                    if(elCh < minCh)
                        minCh = elCh;
                }

                System.out.println("min element = " + minCh);
                break;

            case STRING:
                String minSt = (String) array.get(0);
                String elSt;

                for (int i = 1; i < array.size(); i++) {
                    elSt = (String) array.get(i);
                    int length;

                    if (elSt.length() > minSt.length()) {
                        length = minSt.length();
                    } else {
                        length = elSt.length();
                    }

                    for (int j = 0; j < length; j++) {
                        if (elSt.charAt(j) < minSt.charAt(j)) {
                            minSt = elSt;
                            break;
                        } else if (elSt.charAt(j) > minSt.charAt(j)) {
                            break;
                        }
                    }
                }

                System.out.println("min element = " + minSt);
                break;
        }
    }

    public static void max(Gen gen) {
        ArrayList array = gen.getArray();
        Gen.Type type = gen.getType();

        switch (type) {
            case BYTE:
                byte maxByte = (byte) array.get(0);
                byte elByte;

                for (int i = 1; i < array.size(); i++) {
                    elByte = (byte) array.get(i);
                    if(elByte > maxByte)
                        maxByte = elByte;
                }

                System.out.println("max element = " + maxByte);
                break;

            case SHORT:
                short maxShort = (short) array.get(0);
                short elShort;

                for (int i = 1; i < array.size(); i++) {
                    elShort = (short) array.get(i);
                    if(elShort > maxShort)
                        maxShort = elShort;
                }

                System.out.println("max element = " + maxShort);
                break;

            case INT:
                int maxInt = (int) array.get(0);
                int el;

                for (int i = 1; i < array.size(); i++) {
                    el = (int) array.get(i);
                    if(el > maxInt)
                        maxInt= el;
                }

                System.out.println("max element = " + maxInt);
                break;

            case FLOAT:
                float maxFl = (float) array.get(0);
                float elFl;

                for (int i = 1; i < array.size(); i++) {
                    elFl = (float) array.get(i);
                    if(elFl > maxFl)
                        maxFl = elFl;
                }

                System.out.println("max element = " + maxFl);
                break;

            case CHAR:
                char maxCh = (char) array.get(0);
                char elCh;

                for (int i = 1; i < array.size(); i++) {
                    elCh = (char) array.get(i);
                    if(elCh > maxCh)
                        maxCh = elCh;
                }

                System.out.println("max element = " + maxCh);
                break;

            case STRING:
                String maxSt = (String) array.get(0);
                String elSt;

                for (int i = 1; i < array.size(); i++) {
                    elSt = (String) array.get(i);
                    int length;

                    if (elSt.length() > maxSt.length()) {
                        length = maxSt.length();
                    } else {
                        length = elSt.length();
                    }

                    for (int j = 0; j < length; j++) {
                        if (elSt.charAt(j) > maxSt.charAt(j)) {
                            maxSt = elSt;
                            break;
                        } else if (elSt.charAt(j) < maxSt.charAt(j)) {
                            break;
                        }
                    }
                }

                System.out.println("max element = " + maxSt);
                break;
        }
    }
}

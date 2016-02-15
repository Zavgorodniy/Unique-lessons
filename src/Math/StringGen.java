package Math;

public class StringGen {

    public static String genName() {

        char[][] title = {{'\u0410', '\u0415', '\u0418', '\u041E', '\u0423', '\u042B', '\u042D', '\u042E', '\u042F'},
                {'\u0411', '\u0412', '\u0413', '\u0414', '\u0416', '\u0417', '\u0419', '\u041A', '\u041B', '\u041C', '\u041D', '\u041F',
                        '\u0421', '\u0422', '\u0424', '\u0425', '\u0426', '\u0427', '\u0428', '\u0429'}};

        char[][] next = {{'\u0430', '\u0435', '\u0438', '\u043E', '\u0443', '\u044B', '\u044D', '\u044E', '\u044F','\u044A', '\u044C'},
                {'\u0431', '\u0432', '\u0433', '\u0434', '\u0436', '\u0437', '\u0439', '\u043A', '\u043B', '\u043C', '\u043D', '\u043F',
                        '\u0441', '\u0442', '\u0444', '\u0445', '\u0446', '\u0447', '\u0448', '\u0449'}};

        String name = "";

        int firstCharGroup = (int) (Math.random() * 2);
        int wordLength = (int) (Math.random() * 5 + 2);

        if (firstCharGroup == 0) {
            name += title[firstCharGroup][(int) (Math.random() * 9)];

            for (int i = 0; i < ((wordLength + 1) / 2); i++) {
                name += next[1][random19()];
                name += next[0][random10()];
            }
        } else {
            name += title[firstCharGroup][(int) (Math.random() * 20)];

            for (int i = 0; i < ((wordLength + 1) / 2); i++) {
                name += next[0][random10()];
                name += next[1][random19()];
            }
        }
        return name;
    }

    private static int random10() {
        return (int) (Math.random() * 11);
    }

    private static int random19() {
        return (int) (Math.random() * 20);
    }
}

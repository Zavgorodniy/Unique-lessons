package Math.MathStat;

public class Main {

    public static void main(String[] args) {

        Gen gen = new Gen(Gen.Type.STRING);

        Stat.min(gen);
        Stat.max(gen);

    }
}

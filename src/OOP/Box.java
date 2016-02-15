package OOP;

public class Box {

    int x = 1;
    long y;

    Box(long y) {
        this.y = y;
    }

    Box() {
        this(0);   // вызов конструктора Base(long y)
    }

    public long f() {
        return x*y;
    }
}

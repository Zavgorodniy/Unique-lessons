package OOP;

public class SmallBox extends Box {

    String name = "";

    SmallBox(String name, long par) {
        super(par);   // вызов конструктора Base(long y)
        this.name = name;
    }

    public long g(int r) {
        return r+super.f();   // вызов метода f() класса Base
    }

    public long f() {
        x++;
        return 2*y;
    }
}

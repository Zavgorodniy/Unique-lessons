package OOP;

public class SmallBox extends Box {

    String name = "";

    SmallBox(String name, long par) {
        super(par);   // ����� ������������ Base(long y)
        this.name = name;
    }

    public long g(int r) {
        return r+super.f();   // ����� ������ f() ������ Base
    }

    public long f() {
        x++;
        return 2*y;
    }
}

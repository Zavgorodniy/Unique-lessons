package FileDB;

public class ShipClass {

    public String shipClass;

    public String type;

    public String country;

    public int numGuns;

    public double bore;

    public int displacement;

    public ShipClass(String shipClass, String type, String country, int numGuns, double bore, int displacement) {
        this.shipClass = shipClass;
        this.type = type;
        this.country = country;
        this.numGuns = numGuns;
        this.bore = bore;
        this.displacement = displacement;
    }

    public String toString() {
        return shipClass + ", " + type  + ", " + country + ", " + numGuns + ", " + bore + ", " + displacement;
    }
}

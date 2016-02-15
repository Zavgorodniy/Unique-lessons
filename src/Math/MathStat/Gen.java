package Math.MathStat;

import Math.StringGen;

import java.util.ArrayList;
import java.util.Collections;

public class Gen{

    private int size;
    private Type type;
    private ArrayList array = new ArrayList();

    public int getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public ArrayList getArray() {
        return array;
    }

    Gen() {
        Type[] types = Type.values();
        size = (int) (Math.random() * 13 + 3);
        type = types[(int) (Math.random() * types.length)];
        generate(type, size);
    }

    Gen(Type type) {
        this.type = type;
        size = (int) (Math.random() * 13 + 3);
        generate(type, size);
    }

    Gen(int size) {
        Type[] types = Type.values();
        type = types[(int) (Math.random() * types.length)];
        this.size = size;
        generate(type, size);
    }

    Gen(Type type, int size) {
        this.type = type;
        this.size = size;
        generate(type, size);
    }

    private void generate(Type type, int size) {
        switch (type) {
            case BYTE:
                genByte(size);
                break;
            case CHAR:
                genChar(size);
                break;
            case SHORT:
                genShort(size);
                break;
            case INT:
                genInt(size);
                break;
            case STRING:
                genString(size);
                break;
            case FLOAT:
                genFloat(size);
                break;
        }
    }

    private void genByte(int size) {
        for (int i = 0; i < size; i++) {
            byte el = (byte) (Math.random() * 256 - 127);
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    private void genChar(int size) {
        for (int i = 0; i < size; i++) {
            char el = (char) (Math.random() * 60 + 30);
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    private void genShort(int size) {
        for (int i = 0; i < size; i++) {
            short el = (short) ((Math.random() * 65536) - 32768);
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    private void genInt(int size) {
        for (int i = 0; i < size; i++) {
            int el = (int) ((Math.random() * 200000) - 100000);
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    private void genString(int size) {
        for (int i = 0; i < size; i++) {
            String el = StringGen.genName();
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    private void genFloat(int size) {
        for (int i = 0; i < size; i++) {
            float el = (float) ((Math.random() * 200000) - 100000);
            array.add(el);

            System.out.print(el + " ");
        }
        System.out.println();
    }

    public enum Type {
        BYTE, CHAR, SHORT, INT, STRING, FLOAT
    }
}

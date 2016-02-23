package Collections.Test;

import Collections.MapM;
import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestMapM {
    MapM tst;
    MapM tst1;

    @Before
    public void b() {
        tst = new MapM();
        tst1 = new MapM();
    }

    @Test
    public void testSize1() {
        tst.add(1, 1);
        int exp = 1;
        int act = tst.size();
        assertEquals(act, exp);
    }

    @Test
    public void testReverseWithEmptyArray() {
        assertFalse(tst.reverse());
    }

    @Test
    public void testReverseWithJustOneElementArray() {
        tst.add(1, 1);
        assertFalse(tst.reverse());
    }

    @Test
    public void testSize_0() {
        assertEquals(0, tst.size());
    }

    @Test
    public void testSize_1() {
        tst.add(1, 1);
        assertEquals(1, tst.size());
    }

    @Test
    public void testSize_2() {
        tst.add(1, 1);
        tst.add(2, 1);
        assertEquals(2, tst.size());
    }

    @Test
    public void testSize_3() {
        tst.add(1, 1);
        tst.add(2, 1);
        tst.add(3, 1);
        assertEquals(3, tst.size());
    }

    @Test
    public void testSize_4() {
        tst.add(1, 1);
        tst.add(2, 1);
        tst.add(3, 1);
        tst.add(4, 1);
        assertEquals(4, tst.size());
    }

    @Test
    public void testSize_many() {
        for (int i = 0; i < 17; i++) {
            tst.add(i, i);
        }
        assertEquals(17, tst.size());
    }

    @Test
    public void testSize_many_ForAListR() {
        for (int i = 0; i < 60; i++) {
            tst.add(i, i);
        }
        assertEquals(60, tst.size());
    }

    @Test
    public void testSize_many_ForAListR_100() {
        for (int i = 0; i < 100; i++) {
            tst.add(i, i);
        }
        assertEquals(100, tst.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullKey() {
        tst = new MapM();
        tst.add(null, "value");
    }

    @Test
    public void testAddEl() {
        tst = new MapM();
        tst.add("key", "value");
        Assert.assertEquals(1, tst.size());
    }

    @Test
    public void testAddEq() {
        tst = new MapM();
        tst.add("key", "value");
        tst.add("key", "value");
        Assert.assertEquals(1, tst.size());
    }

    @Test
    public void testAddDif() {
        tst = new MapM();
        tst.add("k", "value");
        tst.add('k', "value");
        Assert.assertEquals(2, tst.size());
    }

    @Test
    public void testAddNullVal() {
        tst = new MapM();
        tst.add("key", null);
        Assert.assertEquals(1, tst.size());
    }

    @Test
    public void testWidening() {
        tst = new MapM(10);
        for (int i = 0; i < 10; i++) {
            tst.add(i, "value");
        }
        tst.add("key", "value");
        Assert.assertEquals(11, tst.size());
    }

    @Test
    public void testGetEmpty() {
        tst = new MapM();
        Assert.assertNull(tst.get("key"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNull() {
        tst = new MapM();
        tst.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        tst = new MapM();
        tst.remove(null);
    }

    @Test
    public void testSortEmpty() {
        tst = new MapM();
        Assert.assertFalse(tst.sort(true));
    }
}
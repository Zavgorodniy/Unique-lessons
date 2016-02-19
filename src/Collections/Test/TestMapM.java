package Collections.Test;

import Collections.MapM;
import org.junit.*;

import Collections.ArrayListM;

public class TestMapM {
    MapM map;

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullKey() {
        map = new MapM();
        map.add(null, "value");
    }

    @Test
    public void testAddEl() {
        map = new MapM();
        map.add("key", "value");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testAddEq() {
        map = new MapM();
        map.add("key", "value");
        map.add("key", "value");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testAddDif() {
        map = new MapM();
        map.add("k", "value");
        map.add('k', "value");
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void testAddNullVal() {
        map = new MapM();
        map.add("key", null);
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testWidening() {
        map = new MapM(10);
        for (int i = 0; i < 10; i++) {
            map.add(i, "value");
        }
        map.add("key", "value");
        Assert.assertEquals(11, map.size());
    }

    @Test
    public void testGetEmpty() {
        map = new MapM();
        Assert.assertNull(map.get("key"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNull() {
        map = new MapM();
        map.get(null);
    }

    @Test
    public void testGetEl() {
        map = new MapM();

        map.get(null);
    }
//    @Test(expected = IllegalArgumentException.class)
//         public void testGetNull() {
//        map = new MapM();
//        map.get(null);
//    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNull() {
        map = new MapM();
        map.remove(null);
    }

    @Test
    public void testSortEmpty() {
        map = new MapM();
        Assert.assertFalse(map.sort(true));
    }

    @Test
    public void testDelPos_many1()
    {
        Integer[] ini = {132,435,57,9,2};
        ArrayListM tst = new ArrayListM(ini);
        tst.remove(2);
        Assert.assertEquals(4, tst.currentIndex + 1);
    }
}

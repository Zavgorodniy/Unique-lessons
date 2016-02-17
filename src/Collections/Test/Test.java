package Collections.Test;

import org.junit.Assert;

import Collections.ArrayListM;

public class Test {

    @org.junit.Test
    public void testDelPos_many1()
    {
        Integer[] ini = {132,435,57,9,2};
        ArrayListM tst = new ArrayListM(ini);;
        tst.remove(2);
        Assert.assertEquals(4, tst.currentIndex);

        int[] actual = new int[tst.currentIndex];
        for (int i = 0; i < tst.currentIndex; i++) {
            actual[i] = (Integer) tst.get(i);
        }

        int[] expected = {132,435,9,2};
        Assert.assertArrayEquals(expected, actual);

    }

}

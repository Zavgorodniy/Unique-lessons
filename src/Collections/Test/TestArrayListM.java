package Collections.Test;

import org.junit.Assert;

import Collections.ArrayListM;

public class TestArrayListM {

    @org.junit.Test
    public void testDelPos_many1()
    {
        Integer[] ini = {132,435,57,9,2};
        ArrayListM tst = new ArrayListM(ini);
        tst.remove(2);
        Assert.assertEquals(4, tst.currentIndex + 1);
    }
}

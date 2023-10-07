package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.annotations.Test;
import org.testng.Assert;


public class IdentityFunctionTest {

    @Test
    public void testApply1()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(1), 1);
    }

    @Test
    public void testApply2()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(4.234), 4.234);
    }

    @Test
    public void testApply3()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(-4563213), -4563213);
    }

    @Test
    public void testApply4()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(5e10), 5e10);
    }

    @Test
    public void testApply5()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(10.04f), 10.04f);
    }

    @Test
    public void testApply6()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(0.00000000432), 0.00000000432);
    }

    @Test
    public void testApply7()
    {
        IdentityFunction o = new IdentityFunction();
        Assert.assertEquals(o.apply(-0.0000000000000000000000000001), -0.0000000000000000000000000001);
    }

}
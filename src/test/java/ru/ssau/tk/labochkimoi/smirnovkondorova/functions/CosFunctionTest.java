package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class CosFunctionTest {

    @Test
    public void testApply1()
    {
        CosFunction o = new CosFunction();
        Assert.assertEquals(o.apply(0), 1);
    }

    @Test
    public void testApply2()
    {
        CosFunction o = new CosFunction();
        Assert.assertEquals(o.apply(3.14), -0.9999987317275395);
    }

    @Test
    public void testApply3()
    {
        CosFunction o = new CosFunction();
        Assert.assertEquals(o.apply(-8), -0.14550003380861354);
    }

    @Test
    public void testApply4()
    {
        CosFunction o = new CosFunction();
        Assert.assertEquals(o.apply(5.11), 0.3872168365049372);
    }

    @Test
    public void testApply5()
    {
        CosFunction o = new CosFunction();
        Assert.assertEquals(o.apply(-34), -0.8485702747846052);
    }

}
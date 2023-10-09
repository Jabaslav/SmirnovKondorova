package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ZeroFunctionTest {

    @Test
    public void testApply1()
    {
        ZeroFunction o = new ZeroFunction();
        Assert.assertEquals(0.0, o.apply(0.0));
    }

    @Test
    public void testApply2()
    {
        ZeroFunction o = new ZeroFunction();
        Assert.assertEquals(0.0, o.apply(-56));
    }

    @Test
    public void testApply3()
    {
        ZeroFunction o = new ZeroFunction();
        Assert.assertEquals(0.0, o.apply(0));
    }
}
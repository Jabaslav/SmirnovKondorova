package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class SqrFunctionTest {

    @Test
    public void testApply1()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(1), 1);
    }

    @Test
    public void testApply2()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(-4.2), 17.64);
    }

    @Test
    public void testApply3()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(-45), 2025);
    }

    @Test
    public void testApply4()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(5.11), 26.1121);
    }

    @Test
    public void testApply5()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(0), 0);
    }

}
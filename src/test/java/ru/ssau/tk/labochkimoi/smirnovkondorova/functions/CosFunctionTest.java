package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class CosFunctionTest {

    @Test
    public void testApply1()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(0), 1);
    }

    @Test
    public void testApply2()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(3.14), -0.999999);
    }

    @Test
    public void testApply3()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(-8), -0.1455);
    }

    @Test
    public void testApply4()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(5.11), 0.387217);
    }

    @Test
    public void testApply5()
    {
        SqrFunction o = new SqrFunction();
        Assert.assertEquals(o.apply(-34), -0.84857);
    }

}
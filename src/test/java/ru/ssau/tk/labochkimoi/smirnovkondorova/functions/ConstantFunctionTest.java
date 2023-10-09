package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ConstantFunctionTest {

    @Test
    public void testApply1()
    {
        ConstantFunction o = new ConstantFunction(5);
        Assert.assertEquals(5.0, o.apply(0.0));
    }

    @Test
    public void testApply2()
    {
        ConstantFunction o = new ConstantFunction(5);
        Assert.assertEquals(5.0, o.apply(-56));
    }

    @Test
    public void testApply3()
    {
        ConstantFunction o = new ConstantFunction(7);
        Assert.assertEquals(7.0, o.apply(0));
    }
}
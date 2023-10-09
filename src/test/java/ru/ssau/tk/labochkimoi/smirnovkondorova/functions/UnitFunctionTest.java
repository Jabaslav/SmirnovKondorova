package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class UnitFunctionTest {

    @Test
    public void testApply1()
    {
        UnitFunction o = new UnitFunction();
        Assert.assertEquals(1.0, o.apply(0.0));
    }

    @Test
    public void testApply2()
    {
        UnitFunction o = new UnitFunction();
        Assert.assertEquals(1.0, o.apply(-56));
    }

    @Test
    public void testApply3()
    {
        UnitFunction o = new UnitFunction();
        Assert.assertEquals(1.0, o.apply(0));
    }
}
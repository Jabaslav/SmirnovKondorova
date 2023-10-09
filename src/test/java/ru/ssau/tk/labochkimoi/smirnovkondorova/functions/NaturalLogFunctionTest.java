package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;
import static org.testng.Assert.*;

public class NaturalLogFunctionTest {

    @Test
    public void testApply1()
    {
        NaturalLogFunction o = new NaturalLogFunction();
        Assert.assertEquals(o.apply(1), 0);
    }

    @Test
    public void testApply2()
    {
        NaturalLogFunction o = new NaturalLogFunction();
        Assert.assertEquals(o.apply(10), 2.302585092994046);
    }

    @Test
    public void testApply3()
    {
        NaturalLogFunction o = new NaturalLogFunction();
        Assert.assertEquals(o.apply(2.7), 0.9932517730102834);
    }

    @Test
    public void testApply4()
    {
        NaturalLogFunction o = new NaturalLogFunction();
        Assert.assertEquals(o.apply(1.1), 0.09531017980432493);
    }

    @Test
    public void testApply5()
    {
        NaturalLogFunction o = new NaturalLogFunction();
        Assert.assertEquals(o.apply(400), 5.991464547107982);
    }
}
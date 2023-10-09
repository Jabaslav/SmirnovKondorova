package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class AndThenTest {
    MathFunction f = x -> x * 2;
    MathFunction g = x -> x + 3;
    MathFunction h = x -> x / 2;

    @Test
    public void testApply() {
        MathFunction o1 = f.andThen(g).andThen(h);
        Assert.assertEquals(2.5, o1.apply(1.0));

        MathFunction o2 = g.andThen(f).andThen(h);
        Assert.assertEquals(4.0, o2.apply(1.0));

        MathFunction o3 = h.andThen(g).andThen(f);
        Assert.assertEquals(7.0, o3.apply(1.0));
    }
}
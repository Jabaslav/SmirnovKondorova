package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    @Test
    public void testApply1() {
        CosFunction a = new CosFunction();
        UnitFunction b = new UnitFunction();
        CompositeFunction complexF = new CompositeFunction(a,b);
        Assert.assertEquals(complexF.apply(1), 1);
    }

    @Test
    public void testApply2() {
        CosFunction a = new CosFunction();
        ZeroFunction b = new ZeroFunction();
        CompositeFunction complexF = new CompositeFunction(b,a);
        Assert.assertEquals(complexF.apply(100), 1);
    }

    @Test
    public void testApply3() {
        /*moreComplexF(complexF)= b(a(b(x)))*/
        ZeroFunction a = new ZeroFunction();
        UnitFunction b = new UnitFunction();
        CompositeFunction complexF = new CompositeFunction(b,a);
        Assert.assertEquals(complexF.apply(1.111), 0);
    }

    @Test
    public void testApply4() {
        /*complexF(complexF)= cos(ln(x)*/
        CosFunction a = new CosFunction();
        NaturalLogFunction b = new NaturalLogFunction();
        CompositeFunction complexF = new CompositeFunction(a,b);
        Assert.assertEquals(complexF.apply(0), 0);
    }

    @Test
    public void testApply5() {
        /*moreComplexF(complexF)= b(a(b(x)))*/
        CosFunction a = new CosFunction();
        UnitFunction b = new UnitFunction();
        CompositeFunction complexF = new CompositeFunction(b,a);
        CompositeFunction moreComplexF = new CompositeFunction(complexF, b);
        Assert.assertEquals(moreComplexF.apply(1), 1);
    }

    @Test
    public void testApply6() {
        /*evenMoreComplexF = moreComplexF(complexF)= d(c(b(a(x))))*/
        ZeroFunction a = new ZeroFunction();
        CosFunction b = new CosFunction();
        NaturalLogFunction c = new NaturalLogFunction();
        IdentityFunction d = new IdentityFunction();

        CompositeFunction complexF = new CompositeFunction(a,b);
        CompositeFunction moreComplexF = new CompositeFunction(c,d);
        CompositeFunction evenMoreComplexF = new CompositeFunction(complexF, moreComplexF);
        Assert.assertEquals(evenMoreComplexF.apply(4123112), 0);
    }

    @Test
    public void testApply7() {
        /*moreComplexF(complexF)= c(b(a(x)))*/
        CosFunction a = new CosFunction();
        ConstantFunction b = new ConstantFunction(5);
        SqrFunction c = new SqrFunction();
        CompositeFunction complexF = new CompositeFunction(a,b);
        CompositeFunction moreComplexF = new CompositeFunction(complexF, c);
        Assert.assertEquals(moreComplexF.apply(1), 25);
    }

    @Test
    public void testApply8() {
        CosFunction a = new CosFunction();
        CompositeFunction complexF = new CompositeFunction(a,a);
        Assert.assertEquals(complexF.apply(0), 0.5403023058681398);
    }

    @Test
    public void testApply9() {
        ConstantFunction a = new ConstantFunction(4);
        NaturalLogFunction b = new NaturalLogFunction();
        CompositeFunction complexF = new CompositeFunction(a,b);
        Assert.assertEquals(complexF.apply(50), 1.3862943611198906);
    }

    @Test
    public void testApply10() {
        SqrFunction a = new SqrFunction();
        IdentityFunction b = new IdentityFunction();
        CompositeFunction complexF = new CompositeFunction(a,b);
        Assert.assertEquals(complexF.apply(1.772004514666935), 3.1399999999999999);
    }
}
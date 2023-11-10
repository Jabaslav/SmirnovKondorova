package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.*;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest
{
@Test
    public void ArrayTabulatedFunctionFactoryTest1()
{
    IdentityFunction o = new IdentityFunction();
    double[] xVal = new double[]{1, 2, 3, 4, 5};
    double[] yVal = new double[xVal.length];
    for (int i = 0; i < xVal.length; i++) {
        yVal[i] = o.apply(xVal[i]);
    }
    LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
    TabulatedDifferentialOperator difOperator = new TabulatedDifferentialOperator();
    ArrayTabulatedFunction difFunction = (ArrayTabulatedFunction) difOperator.derive(listF);
    assertEquals(difFunction.getY(0), 1);
}
    @Test
    public void ArrayTabulatedFunctionFactoryTest2()
    {
        IdentityFunction o = new IdentityFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        TabulatedDifferentialOperator difOperator = new TabulatedDifferentialOperator();
        ArrayTabulatedFunction difFunction = (ArrayTabulatedFunction) difOperator.derive(listF);
        assertEquals(difFunction.getY(0), 1);
    }
    @Test
    public void LinkedListTabulatedFunctionFactoryTest1()
    {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 3, 5, 7, 9};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        TabulatedDifferentialOperator difOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        LinkedListTabulatedFunction difFunction = (LinkedListTabulatedFunction) difOperator.derive(listF);
        assertEquals(difFunction.getY(0), 4);
        assertEquals(difFunction.getY(1), 8);
        assertEquals(difFunction.getY(2), 12);
    }
    @Test
    public void LinkedListTabulatedFunctionFactoryTest2()
    {
        UnitFunction o = new UnitFunction();
        double[] xVal = new double[]{1, 3, 5, 7, 9};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        TabulatedDifferentialOperator difOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        LinkedListTabulatedFunction difFunction = (LinkedListTabulatedFunction) difOperator.derive(listF);
        assertEquals(difFunction.getY(0), 0);
    }
}
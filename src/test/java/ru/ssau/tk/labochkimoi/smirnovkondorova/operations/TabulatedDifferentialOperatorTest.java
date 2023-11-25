package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.*;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest {
    @Test
    public void testArrayTabulatedFunctionFactory1() {
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
    public void testArrayTabulatedFunctionFactory2() {
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
    public void testLinkedListTabulatedFunctionFactory1() {
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
    public void testLinkedListTabulatedFunctionFactory2() {
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

    @Test
    void deriveSynchronouslyTest() {
        double[] xVal = {1, 2, 3, 4};
        double[] yVal = {10, 20, 30, 40};
        LinkedListTabulatedFunctionFactory fact = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operation = new TabulatedDifferentialOperator(fact);
        ArrayTabulatedFunction func = new ArrayTabulatedFunction(xVal, yVal);
        TabulatedFunction differential_func = operation.deriveSynchronously(func);
        assertEquals(10, differential_func.getY(0));
        assertEquals(10, differential_func.getY(1));
        assertEquals(10, differential_func.getY(2));
        assertEquals(10, differential_func.getY(3));
    }
}
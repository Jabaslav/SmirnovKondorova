package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.SqrFunction;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionFactoryTest {
    @Test
    public void testCreate1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        assertTrue(factory.create(xVal, yVal) instanceof ArrayTabulatedFunction);
    }

    @Test
    public void testCreate2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        assertTrue(factory.create(xVal, yVal) instanceof ArrayTabulatedFunction);
    }
}
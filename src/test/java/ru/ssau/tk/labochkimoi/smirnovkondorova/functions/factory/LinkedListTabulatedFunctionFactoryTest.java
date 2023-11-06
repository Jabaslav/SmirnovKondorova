package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.SqrFunction;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {
    @Test
    public void CreateTest1 ()
    {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        assertTrue(factory.create(xVal, yVal) instanceof LinkedListTabulatedFunction);
    }

    @Test
    public void CreateTest2 ()
    {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        assertTrue(factory.create(xVal, yVal) instanceof LinkedListTabulatedFunction);
    }
}
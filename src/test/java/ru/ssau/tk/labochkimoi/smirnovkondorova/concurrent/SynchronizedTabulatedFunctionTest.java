package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SynchronizedTabulatedFunctionTest {
    double[] xValue = {1, 2, 3, 4, 5};
    double[] yValue = {10, 20, 30, 40, 50};
    ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValue, yValue);
    SynchronizedTabulatedFunction synchronizedTabulatedFunction=new SynchronizedTabulatedFunction(function);

    @Test
    public void doSynchronously() {
        SynchronizedTabulatedFunction.Operation<Double> operation = func -> {
            double sum = 0;
            for (Point el : synchronizedTabulatedFunction)
                sum += el.y;
            return sum;
        };
        double sumOfY = synchronizedTabulatedFunction.doSynchronously(operation);
        Assert.assertEquals(150, sumOfY);
    }

}

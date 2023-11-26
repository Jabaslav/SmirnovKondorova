package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;

public class SynchronizedTabulatedFunctionTest {
    double[] xValue = {1, 2, 3, 4, 5};
    double[] yValue = {10, 20, 30, 40, 50};
    ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValue, yValue);
    SynchronizedTabulatedFunction synchronizedTabulatedFunction=new SynchronizedTabulatedFunction(function);

    @Test
    public void methodsTest() {
        Assert.assertEquals(5, synchronizedTabulatedFunction.getCount());
        Assert.assertEquals(1, synchronizedTabulatedFunction.getX(0));
        Assert.assertEquals(30, synchronizedTabulatedFunction.getY(2));
        Assert.assertEquals(-1, synchronizedTabulatedFunction.indexOfY(19));
        synchronizedTabulatedFunction.setY(2, 19);
        Assert.assertEquals(2, synchronizedTabulatedFunction.indexOfY(19));
        Assert.assertEquals(19, synchronizedTabulatedFunction.getY(2));
        Assert.assertEquals(3, synchronizedTabulatedFunction.indexOfX(4));
        Assert.assertEquals(5, synchronizedTabulatedFunction.rightBound());
        Assert.assertEquals(1, synchronizedTabulatedFunction.leftBound());
    }

    @Test
    void iteratorTest() {
        int i = 0;
        for (Point point : synchronizedTabulatedFunction) {
            Assert.assertEquals(point.x, synchronizedTabulatedFunction.getX(i));
            Assert.assertEquals(point.y, synchronizedTabulatedFunction.getY(i));
            ++i;
        }
    }

    @Test
    public void doSynchronously1Test() {
        SynchronizedTabulatedFunction.Operation<Double> operation = func -> {
            double sum = 0;
            for (Point el : synchronizedTabulatedFunction)
                sum += el.y;
            return sum;
        };
        double sumOfY = operation.apply(synchronizedTabulatedFunction);
        Assert.assertEquals(150, sumOfY);
    }

    @Test
    public void doSynchronously2Test() {
        SynchronizedTabulatedFunction.Operation<Double> operation = func -> {
            double sum = 0;
            for (Point el : synchronizedTabulatedFunction)
                sum += el.x;
            return sum;
        };
        double sumOfX = operation.apply(synchronizedTabulatedFunction);
        Assert.assertEquals(15, sumOfX);
    }

    @Test
    public void doSynchronously3Test() {
        SynchronizedTabulatedFunction.Operation<Void> operation = func -> {

            synchronizedTabulatedFunction.setY(0, 2);
            synchronizedTabulatedFunction.setY(1, 2);
            return null;
        };
        operation.apply(synchronizedTabulatedFunction);
        Assert.assertEquals(2, synchronizedTabulatedFunction.getY(0));
        Assert.assertEquals(2, synchronizedTabulatedFunction.getY(1));
    }

    @Test
    public void doSynchronously4Test() {
        SynchronizedTabulatedFunction.Operation<Boolean> operation = func -> {
            return synchronizedTabulatedFunction.getY(0) == synchronizedTabulatedFunction.getY(1);
        };

        Assert.assertTrue(operation.apply(synchronizedTabulatedFunction));
    }

}

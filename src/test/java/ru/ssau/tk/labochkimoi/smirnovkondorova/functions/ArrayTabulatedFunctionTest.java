package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.InterpolationException;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.DifferentLengthOfArraysException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayTabulatedFunctionTest {
    double[] xValue = {1, 2, 3, 4, 5};
    double[] yValue = {10, 20, 30, 40, 50};
    ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValue, yValue);
    ArrayTabulatedFunction o = new ArrayTabulatedFunction(xValue, yValue);

    @Test
    void getCount() {
        Assert.assertEquals(5, o.getCount());
    }
    @Test
    void getX() {
        Assert.assertEquals(2, o.getX(1));
    }
    @Test
    void getY() {
        Assert.assertEquals(20, o.getY(1));
    }
    @Test
    void setY() {
        o.setY(0, 7);
        Assert.assertEquals(7, o.getY(0));
    }
    @Test
    void leftBound() {
        Assert.assertEquals(1, o.leftBound());
        Assert.assertNotEquals(0, o.leftBound());
    }
    @Test
    void rightBound() {
        Assert.assertEquals(5, o.rightBound());
        Assert.assertNotEquals(0, o.rightBound());
    }
    @Test
    void indexOfX() {
        Assert.assertEquals(-1, o.indexOfX(1.5));
        Assert.assertEquals(0, o.indexOfX(1));
    }
    @Test
    void indexOfY() {
        Assert.assertEquals(-1, o.indexOfY(1));
        Assert.assertEquals(1, o.indexOfY(20));
    }
    @Test
    void floorIndexOfX() {
        Assert.assertEquals(5, o.floorIndexOfX(10));
    }
    @Test
    void interpolate() {
        Assert.assertEquals(105, o.interpolate(10.5, 2));
        Assert.assertEquals(403, o.interpolate(40.3, 1));
    }
    @Test
    void extrapolateLeft() {
        Assert.assertEquals(-50, o.extrapolateLeft(-5));
    }
    @Test
    void extrapolateRight() {
        Assert.assertEquals(100, o.extrapolateRight(10));
    }
    @Test
    void toStringTest() {
        Assert.assertEquals("(1.0;10.0) (2.0;20.0) (3.0;30.0) (4.0;40.0) (5.0;50.0) ", arrayTabulatedFunction.toString());
    }

    @Test
    void equalsTest() {
        ArrayTabulatedFunction arrayTabulatedFunctionTest = new ArrayTabulatedFunction(xValue, yValue);
        Assert.assertTrue(arrayTabulatedFunction.equals(arrayTabulatedFunctionTest));
    }
    @Test
    void hashCodeTest() {
        ArrayTabulatedFunction arrayTabulatedFunction1 = new ArrayTabulatedFunction(xValue, yValue);
        Assert.assertEquals(arrayTabulatedFunction.hashCode(), arrayTabulatedFunction1.hashCode());
    }
    @Test
    void cloneTest() {
        Object arrayTabulatedFunctionTest = arrayTabulatedFunction.clone();
        Assert.assertEquals(arrayTabulatedFunction, arrayTabulatedFunctionTest);
    }

    @Test (expectedExceptions={IllegalArgumentException.class})
    void IllegalArgumentTest1()
    {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        ArrayTabulatedFunction arrayTabulatedFunction1 = new ArrayTabulatedFunction(xVal, yVal);
    }

    @Test (expectedExceptions={IllegalArgumentException.class})
    void IllegalArgumentTest2()
    {
        ArrayTabulatedFunction arrayTabulatedFunction1 = new ArrayTabulatedFunction(xValue, yValue);
        arrayTabulatedFunction1.floorIndexOfX(0);
    }
    @Test
    void ArrayTabulatedFunctionLengthException() {
        double[] xValue2 = {0, 1, 2};
        double[] yValue2 = {3, 4, 5, 6};
        Assert.assertThrows(DifferentLengthOfArraysException.class, () -> {
            ArrayTabulatedFunction arrTabulatedFunction2 = new ArrayTabulatedFunction(xValue2, yValue2);
        });
    }

    @Test
    void ArrayTabulatedFunctionSortedException() {
        double[] xValue5 = {1, 4, 2, 5, 3, 0};
        double[] yValue5 = {0, 1, 2, 3, 4, 5};
        Assert.assertThrows(ArrayIsNotSortedException.class, () -> {
            ArrayTabulatedFunction arrTabulatedFunction25 = new ArrayTabulatedFunction(xValue5, yValue5);
        });
    }
    @Test
    void interpolateTestException() {
        Assert.assertThrows(InterpolationException.class, () -> {
            arrayTabulatedFunction.interpolate(5.5, 5);
        });
    }
}
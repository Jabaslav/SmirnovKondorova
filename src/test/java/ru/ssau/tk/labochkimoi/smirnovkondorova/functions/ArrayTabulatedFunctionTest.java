package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;


import org.testng.Assert;
import org.testng.annotations.Test;


public class ArrayTabulatedFunctionTest {
    double[] xValue = {1, 2, 3, 4, 5};
    double[] yValue = {10, 20, 30, 40, 50};
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
        Assert.assertEquals(0, o.floorIndexOfX(-10));
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
}
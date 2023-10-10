package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

    @Test
    public void testFloorIndexOfX1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.floorIndexOfX(1), 0);
    }

    @Test
    public void testFloorIndexOfX2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.floorIndexOfX(2), 4);
    }

    @Test
    public void testFloorIndexOfX3() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.floorIndexOfX(1.3), 2);
    }

    @Test
    public void testFloorIndexOfX4() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.floorIndexOfX(-1.11), 0);
    }

    @Test
    public void testFloorIndexOfX5() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.floorIndexOfX(5), 10);
    }

    @Test
    public void testExtrapolateLeft1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 1, 10, 10);
        Assert.assertEquals(listF.extrapolateLeft(0), 0);
    }

    @Test
    public void testExtrapolateLeft2() {
        ConstantFunction o = new ConstantFunction(5);
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 1, 2, 11);
        Assert.assertEquals(listF.extrapolateLeft(0.5), 5);
    }

    @Test
    public void testExtrapolateLeft3() {
        ZeroFunction o = new ZeroFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 14, 15, 11);
        Assert.assertEquals(listF.extrapolateLeft(0.5), 0);
    }

    @Test
    public void testExtrapolateRight1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 1, 10, 10);
        Assert.assertEquals(listF.extrapolateRight(11), 11);
    }

    @Test
    public void testExtrapolateRight2() {
        ConstantFunction o = new ConstantFunction(2);
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 0, 10, 11);
        Assert.assertEquals(listF.extrapolateRight(11), 2);
    }

    @Test
    public void testExtrapolateRight3() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 0, 10, 11);
        Assert.assertEquals((int) listF.extrapolateRight(11), 119);
    }

    @Test
    public void testInterpolate1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.interpolate(3.5, 2), 12.5);
    }


    @Test
    public void testGetCount1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.getCount(), 5);
    }

    @Test
    public void testGetCount2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.getCount(), 10);
    }

    @Test
    public void testGetCount3() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.getCount(), 1);
    }

    @Test
    public void testGetCount4() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.getCount(), 11);
    }

    @Test
    public void testGetX1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.getX(-1), 2);
    }

    @Test
    public void testGetX2() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.getX(0), 3);
    }

    @Test
    public void testGetX3() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.getX(11), 3);

    }

    @Test
    public void testGetY1() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.getY(4), 2.25);
    }

    @Test
    public void testGetY2() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals((int) listF.getY(-1), 16);
    }

    @Test
    public void testGetY3() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals((int) listF.getY(21), 16);
    }

    @Test
    public void testSetY1() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        listF.setY(4, 44);
        Assert.assertEquals(listF.getY(4), 44);

    }

    @Test
    public void testSetY2() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        listF.setY(11, -1);
        Assert.assertEquals(listF.getY(11), -1);

    }

    @Test
    public void testSetY3() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        listF.setY(21, 12.48);
        Assert.assertEquals(listF.getY(21), 12.48);

    }

    @Test
    public void testIndexOfX1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfX(25), -1);
    }

    @Test
    public void testIndexOfX2() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfX(9), -1);
    }

    @Test
    public void testIndexOfX3() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfX(4), 10);
    }

    @Test
    public void testIndexOfY1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfY(3.1), 1);

    }

    @Test
    public void testIndexOfY2() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfY(25), -1);

    }

    @Test
    public void testIndexOfY3() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 3, 4, 11);
        Assert.assertEquals(listF.indexOfY(4), 10);

    }

    @Test
    public void testLeftBound1() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 4, 10, 11);
        Assert.assertEquals(listF.leftBound(), 4);

    }

    @Test
    public void testLeftBound2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.leftBound(), 1);

    }

    @Test
    public void testRightBound1() {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 4, 10, 11);
        Assert.assertEquals(listF.rightBound(), 10);
    }

    @Test
    public void testRightBound2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.rightBound(), 10);

    }
}
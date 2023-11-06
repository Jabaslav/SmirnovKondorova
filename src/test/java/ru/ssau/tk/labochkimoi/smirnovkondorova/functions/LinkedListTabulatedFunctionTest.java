package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.InterpolationException;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.DifferentLengthOfArraysException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

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

    @Test
    public void testNodeHashCode1() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(4.1, 5.2);
        assertEquals(node.hashCode(), node2.hashCode());
        assertNotEquals(node.hashCode(), node3.hashCode());
    }

    @Test
    public void testNodeToString1() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        assertEquals(node.toString(), "(2.1; 3.33), где 2.1 и 3.33 - абсцисса и ордината точки соответственно.");
    }

    @Test
    public void testNodeToString2() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(12.3, 56.66);
        assertEquals(node.toString(), "(12.3; 56.66), где 12.3 и 56.66 - абсцисса и ордината точки соответственно.");
    }

    @Test
    public void testNodeEquals1() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(4.1, 5.2);
        assertEquals(node.equals(node2), node2.equals(node));
        assertEquals(node2, node);
        assertNotEquals(node3, node);
        assertEquals(node.equals(node3), node3.equals(node));
    }

    @Test
    public void testNodeClone() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(2.1, 3.33);
        LinkedListTabulatedFunction.Node node2 = (LinkedListTabulatedFunction.Node) node.clone();
        assertEquals(node, node2);
        assertEquals(node.hashCode(), node2.hashCode());
        assertEquals(node2, node);
        assertNotSame(node, node2);
    }

    @Test
    public void testLLTFtoString1() {
        IdentityFunction o = new IdentityFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        assertEquals(listF.toString(), "(1.0; 1.0) (2.0; 2.0) (3.0; 3.0) (4.0; 4.0) (5.0; 5.0) ");
    }

    @Test
    public void testLLTFtoString2() {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        assertEquals(listF.toString(), "(1.0; 1.0) (2.0; 4.0) (3.0; 9.0) (4.0; 16.0) (5.0; 25.0) ");
    }

    @Test
    public void testLLTFClone()  {
        SqrFunction o = new SqrFunction();
        LinkedListTabulatedFunction listF1 = new LinkedListTabulatedFunction(o, 1, 3, 3);
        LinkedListTabulatedFunction listF2 = (LinkedListTabulatedFunction) listF1.clone();
        assertNotSame(listF1, listF2);
        assertEquals(listF1.toString(), listF2.toString());
    }

    @Test
    public void testLLTFEquals1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF1 = new LinkedListTabulatedFunction(o, 1, 3, 3);
        LinkedListTabulatedFunction listF2 = new LinkedListTabulatedFunction(o, 1, 3, 3);
        LinkedListTabulatedFunction listF3 = new LinkedListTabulatedFunction(o, 1, 4, 4);
        LinkedListTabulatedFunction listF4 = new LinkedListTabulatedFunction(o, 1, 3.6, 3);
        assertNotEquals(listF3, listF1);
        assertEquals(listF1.equals(listF2), listF2.equals(listF1));
        assertEquals(listF1.equals(listF3), listF3.equals(listF1));
        assertNotEquals(listF1, listF4);
    }

    @Test
    public void testLLTFHashCode1() {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF1 = new LinkedListTabulatedFunction(o, 1, 3, 3);
        LinkedListTabulatedFunction listF2 = new LinkedListTabulatedFunction(o, 1, 3, 3);
        LinkedListTabulatedFunction listF3 = new LinkedListTabulatedFunction(o, 1, 4, 4);
        assertEquals(listF1.hashCode(), listF2.hashCode());
        assertNotEquals(listF1.hashCode(), listF3.hashCode());
        listF1.setY(0, 1.1);
        assertNotEquals(listF1.hashCode(), listF2.hashCode());

    }

    @Test (expectedExceptions={IllegalArgumentException.class})
    public void IllegalArgumentTest1()
    {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF1 = new LinkedListTabulatedFunction(o, 1, 3, 1);
    }

    @Test (expectedExceptions={IllegalArgumentException.class})
    public void IllegalArgumentTest2()
    {
        SqrFunction o = new SqrFunction();
        double[] xVal = new double[]{1.1};
        double[] yVal = new double[xVal.length];
        for (int i = 0; i < xVal.length; i++) {
            yVal[i] = o.apply(xVal[i]);
        }
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
    }

    @Test (expectedExceptions={IllegalArgumentException.class})
    public void IllegalArgumentTest3()
    {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF1 = new LinkedListTabulatedFunction(o, 1, 3, 10);
        listF1.floorIndexOfX(0.9);
    }

    @Test
    public void IteratorTest1()
    {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 0, 10, 11);
        Iterator<Point> iterator = listF.iterator();
        StringBuilder Stringer = new StringBuilder();
        while (iterator.hasNext())
        { Point point = iterator.next();
            Stringer.append((int)point.x).append(" ");
        }
        assertEquals(Stringer.toString(),"0 1 2 3 4 5 6 7 8 9 10 ");
    }

    @Test
    public void IteratorTest2()
    {
        IdentityFunction o = new IdentityFunction();
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(o, 0, 10, 11);
        StringBuilder Stringer = new StringBuilder();
        for (Point point: listF)
        {
            Stringer.append((int)point.x).append(" ");
        }
        assertEquals(Stringer.toString(),"0 1 2 3 4 5 6 7 8 9 10 ");
    }
    @Test
    void LinkedListTabulatedFunctionLengthException() {
        double[] xValue2 = {1, 2, 3};
        double[] yValue2 = {4, 5};
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            LinkedListTabulatedFunction linkedListTabulatedFunction2 = new LinkedListTabulatedFunction(xValue2, yValue2);
        });
    }

    @Test
    void LinkedListTabulatedFunctionSortedException() {
        double[] xValue2 = {1, 4, 3, 2, 5, 0};
        double[] yValue2 = {0, 1, 2, 3, 4, 5};
        assertThrows(ArrayIsNotSortedException.class, () -> {
            LinkedListTabulatedFunction linkedListTabulatedFunction25 = new LinkedListTabulatedFunction(xValue2, yValue2);
        });
    }
    @Test
    void LinkedListInterpolateTestException() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertThrows(InterpolationException.class, () -> {
            function.interpolate(5.5, 5);
        });
    }
}
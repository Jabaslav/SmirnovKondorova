package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbstractTabulatedFunctionTest {

    @Test
    public void testTestToString1() {
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[]{1, 2, 3, 4, 5};
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.toString(), "LinkedListTabulatedFunction count = 5\n[1.0; 1.0]\n[2.0; 2.0]\n[3.0; 3.0]\n[4.0; 4.0]\n[5.0; 5.0]");
    }

    @Test
    public void testTestToString2() {
        double[] xVal = new double[]{1, 2, 3, 4, 5};
        double[] yVal = new double[]{2, 3, 4, 5, 6};
        ArrayTabulatedFunction listF = new ArrayTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.toString(), "ArrayTabulatedFunction count = 5\n[1.0; 2.0]\n[2.0; 3.0]\n[3.0; 4.0]\n[4.0; 5.0]\n[5.0; 6.0]");
    }

    @Test
    public void testTestToString3() {
        double[] xVal = new double[]{0, 0.5, 1};
        double[] yVal = new double[]{0, 0.25, 1};
        LinkedListTabulatedFunction listF = new LinkedListTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.toString(), "LinkedListTabulatedFunction count = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]");
    }

    @Test
    public void testTestToString4() {
        double[] xVal = new double[]{0, 0.5, 1, 1.5, 2};
        double[] yVal = new double[]{0, 0.25, 1, 2.25, 4};
        ArrayTabulatedFunction listF = new ArrayTabulatedFunction(xVal, yVal);
        Assert.assertEquals(listF.toString(), "ArrayTabulatedFunction count = 5\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]\n[1.5; 2.25]\n[2.0; 4.0]");
    }
}
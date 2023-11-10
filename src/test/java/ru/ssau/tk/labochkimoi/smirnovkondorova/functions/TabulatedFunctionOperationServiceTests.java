package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService;

public class TabulatedFunctionOperationServiceTests {
    double[] xValue = {1, 1.25, 1.5, 1.75, 2};
    double[] yValue1 = {1, 2, 3, 4, 5};
    double[] yValue2 = {6, 7, 8, 9, 10};
    ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(xValue, yValue1);
    ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(xValue,yValue2);
    LinkedListTabulatedFunction func3 = new LinkedListTabulatedFunction(xValue, yValue1);
    LinkedListTabulatedFunction func4 = new LinkedListTabulatedFunction(xValue,yValue2);
    TabulatedFunctionOperationService operation = new TabulatedFunctionOperationService();
    TabulatedFunctionOperationService operation2 = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());

    @Test
    void asPointsTest() {
        Point[] arrayOfPoints = TabulatedFunctionOperationService.asPoints(func1);

        int i = 0;
        for (Point point : arrayOfPoints) {
            Assert.assertEquals(point.x, xValue[i]);
            Assert.assertEquals(point.y, yValue1[i]);
            ++i;
        }
    }
    @Test
    void addTest() {

        TabulatedFunction result1 = operation.add(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assert.assertEquals(yValue1[i] + yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation.add(func3, func4);
        for (int i = 0; i < result2.getCount(); i++) {
            Assert.assertEquals(yValue1[i] + yValue2[i], result2.getY(i));
        }

        TabulatedFunction result3 = operation.add(func1, func4);
        for (int i = 0; i < result3.getCount(); i++) {
            Assert.assertEquals(yValue1[i] + yValue2[i], result3.getY(i));
        }
    }
    @Test
    void subtractionTest() {
        TabulatedFunction result1 = operation.subtract(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assert.assertEquals(yValue1[i] - yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation.subtract(func4, func3);
        for (int i = 0; i < result2.getCount(); i++) {
            Assert.assertEquals(yValue2[i] - yValue1[i], result2.getY(i));
        }


        TabulatedFunction result3 = operation.subtract(func1, func4);
        for (int i = 0; i < result3.getCount(); i++) {
            Assert.assertEquals(yValue1[i] - yValue2[i], result3.getY(i));
        }
    }

    @Test
    void multiplyTest1() {
        ArrayTabulatedFunction result1 = (ArrayTabulatedFunction) operation.multiply(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assert.assertEquals(yValue1[i] * yValue2[i], result1.getY(i));
        }
    }
@Test
    void multiplyTest2() {
    LinkedListTabulatedFunction result2 = (LinkedListTabulatedFunction) operation2.multiply(func4, func3);
    for (int i = 0; i < result2.getCount(); i++) {
        Assert.assertEquals(yValue2[i] * yValue1[i], result2.getY(i));
    }

    }
    @Test
    void multiplyTest3() {
        TabulatedFunction result3 = operation2.multiply(func1, func4);
        for (int i = 0; i < result3.getCount(); i++) {
            Assert.assertEquals(yValue1[i] * yValue2[i], result3.getY(i));
        }
    }
    @Test
    void divideTest1() {
        ArrayTabulatedFunction result1 = (ArrayTabulatedFunction) operation.divide(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assert.assertEquals(yValue1[i] / yValue2[i], result1.getY(i));
        }
    }

    @Test
    void divideTest2() {
        LinkedListTabulatedFunction result2 = (LinkedListTabulatedFunction) operation2.divide(func4, func3);
        for (int i = 0; i < result2.getCount(); i++) {
            Assert.assertEquals(yValue2[i] / yValue1[i], result2.getY(i));
        }
    }

    @Test
    void divideTest3() {
        TabulatedFunction result3 = operation.divide(func1, func4);
        for (int i = 0; i < result3.getCount(); i++) {
            Assert.assertEquals(yValue1[i] / yValue2[i], result3.getY(i));
        }
    }
}

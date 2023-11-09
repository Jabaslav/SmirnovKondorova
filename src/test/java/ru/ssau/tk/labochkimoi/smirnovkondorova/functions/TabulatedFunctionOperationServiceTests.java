package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService;

public class TabulatedFunctionOperationServiceTests {
    double[] xValue = {1, 1.25, 1.5, 1.75, 2};
    double[] yValue1 = {1, 2, 3, 4, 5};
    ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(xValue, yValue1);

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
}

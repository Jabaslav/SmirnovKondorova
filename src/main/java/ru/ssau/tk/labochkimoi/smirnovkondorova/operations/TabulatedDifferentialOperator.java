package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent.SynchronizedTabulatedFunction;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator()
    {
        factory = new ArrayTabulatedFunctionFactory();
    }
    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory)
    {
        this.factory = factory;
    }

    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        int length = points.length;
        double[] xValues = new double[length];
        double[] yValues = new double[length];
        for (int i = 0; i < length; i++)
            xValues[i] = points[i].x;
        for (int i = 0; i < length-1; i++)
        {
            yValues[i]=(points[i+1].y-points[i].y)/(xValues[i+1]-xValues[i]);
        }
        yValues[length-1]= yValues[length-2];
        return factory.create(xValues, yValues);
    }

    public SynchronizedTabulatedFunction deriveSynchronously(TabulatedFunction function) {
        SynchronizedTabulatedFunction synchronizedFunction;

        if (function instanceof SynchronizedTabulatedFunction) {
            synchronizedFunction = (SynchronizedTabulatedFunction) function;
        } else {
            synchronizedFunction = new SynchronizedTabulatedFunction(function);
        }

        return synchronizedFunction.doSynchronously(func -> new SynchronizedTabulatedFunction(derive(func)));
    }
}

package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.InconsistentFunctionsException;

public class TabulatedFunctionOperationService {
    protected TabulatedFunctionFactory factory;

    public TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionOperationService() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionFactory getFactory() {
        return this.factory;
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        Point[] points = new Point[tabulatedFunction.getCount()];
        int i = 0;
        for (Point point : tabulatedFunction) {
            points[i++] = point;
        }
        return points;
    }
    private interface BiOperation {
        double apply(double u, double v);
    }

    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation) {
        if (a.getCount() != b.getCount()) throw new InconsistentFunctionsException();

        Point[] pointsA = asPoints(a);
        Point[] pointsB = asPoints(b);

        double[] xValues = new double[a.getCount()];
        double[] yValues = new double[a.getCount()];

        for (int i = 0; i < a.getCount(); i++) {
           if (pointsA[i].x != pointsB[i].x) {
                throw new InconsistentFunctionsException("X values in the functions do not match");
            }
            xValues[i] = pointsA[i].x;
            yValues[i] = operation.apply(pointsA[i].y, pointsB[i].y);
        }

        return factory.create(xValues, yValues);
    }
    public void doOperation(double[] xValues1, double[] yValues1, double[] xValues2, double[] yValues2, BiOperation operation) {
        doOperation(factory.create(xValues1, yValues1), factory.create(xValues2, yValues2), operation);
    }

    public TabulatedFunction add(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u + v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction subtract(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u - v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction multiply(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u * v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction divide(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u / v;
        return doOperation(firstFunction, secondFunction, operation);
    }
    public enum Operation {
        add, subtract, multiply, divide
    }
}

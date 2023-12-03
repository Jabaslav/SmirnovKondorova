package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public ArrayTabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    public ArrayTabulatedFunction create(MathFunction source, double xFrom, double xTo, int count)
    {
        return new ArrayTabulatedFunction(source, xFrom, xTo, count);
    }
}

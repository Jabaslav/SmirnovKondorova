package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public LinkedListTabulatedFunction create(double[] xValues, double[] yValues)
    {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    public LinkedListTabulatedFunction create(MathFunction source, double xFrom, double xTo, int count)
    {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }
}

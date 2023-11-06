package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public LinkedListTabulatedFunction create(double[] xValues, double[] yValues)
    {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
}

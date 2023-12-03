package ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);

    TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count);
}

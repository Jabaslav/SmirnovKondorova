package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;
public interface DifferentialOperator<T extends MathFunction > {
    T derive(T function);
}

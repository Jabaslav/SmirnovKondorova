package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;
public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator{
    public LeftSteppingDifferentialOperator(double step) {
        super(step);
    }
    public MathFunction derive(MathFunction function) {
        return (x) -> (function.apply(x) - function.apply(x - step)) / step;
    }
}

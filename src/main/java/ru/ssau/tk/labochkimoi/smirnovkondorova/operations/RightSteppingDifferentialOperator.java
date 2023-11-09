package ru.ssau.tk.labochkimoi.smirnovkondorova.operations;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.MathFunction;
public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator{
    public RightSteppingDifferentialOperator(double step) {
        super(step);
    }
    public MathFunction derive(MathFunction function) {
        return (x) -> ((function.apply(x + step) - function.apply(x)) / step);
    }
}

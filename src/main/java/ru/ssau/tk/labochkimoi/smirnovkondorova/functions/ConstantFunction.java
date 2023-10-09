package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

public class ConstantFunction implements MathFunction {
    private final double constant;

    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    public double apply(double x) {
        return constant;
    }

    public double getConstant() {
        return constant;
    }
}

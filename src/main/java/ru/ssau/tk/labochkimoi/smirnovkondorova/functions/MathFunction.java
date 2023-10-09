package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

public interface MathFunction {
    double apply (double x);

    default MathFunction andThen(MathFunction afterFunction) {
        return (double x) -> afterFunction.apply(this.apply(x));
    }
}

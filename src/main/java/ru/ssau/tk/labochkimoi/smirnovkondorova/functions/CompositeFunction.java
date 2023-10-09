package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

public class CompositeFunction implements MathFunction
{
    private final MathFunction firstFunction;
    private final MathFunction secondFunction;

    public CompositeFunction(MathFunction first, MathFunction second)
    {
        firstFunction = first;
        secondFunction = second;
    }
    public double apply(double x)
    {
        return(secondFunction.apply(firstFunction.apply(x)));
    }
}

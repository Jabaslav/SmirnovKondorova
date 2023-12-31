package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;
public class IdentityFunction implements MathFunction, Cloneable
{
    public double apply(double x) {
        return(x);
    }
    public String toString() {
        return "IdentityFunction";
    }
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
    public int hashCode() {
        return getClass().hashCode();
    }
    public Object clone() {
        return new IdentityFunction();
    }
}

package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;

import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.labochkimoi.smirnovkondorova.exceptions.DifferentLengthOfArraysException;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    protected int count;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX);
    }

    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else {
            int index = floorIndexOfX(x);
            if (index != -1) {
                return getY(index);
            } else {
                return interpolate(x, index);
            }
        }
    }

    public static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("different length");
        }
    }

    public static void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i] > xValues[i + 1]) throw new ArrayIsNotSortedException("not sorted");

        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append(' ').append("count = ").append(count);
        for (Point point : this) {
            stringBuilder.append("\n").append('[').append(point.x).append("; ").append(point.y).append(']');
        }
        return stringBuilder.toString();
    }
}
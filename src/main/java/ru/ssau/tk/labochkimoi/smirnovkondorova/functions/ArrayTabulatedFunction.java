package ru.ssau.tk.labochkimoi.smirnovkondorova.functions;
import java.util.Arrays;
public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements TabulatedFunction, Cloneable {
    private final double[] xValues;
    private final double[] yValues;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        this.xValues = Arrays.copyOf(xValues, xValues.length);
        this.yValues = Arrays.copyOf(yValues, yValues.length);
        this.count = xValues.length;
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }
        this.xValues = new double[count];
        this.yValues = new double[count];
        this.count = count;
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            double x = xFrom + step * i;
            this.xValues[i] = x;
            this.yValues[i] = source.apply(x);
        }
    }

    public int getCount() {
        return count;
    }

    public double getX(int index) {
        return xValues[index];
    }

    public double getY(int index) {
        return yValues[index];
    }

    public void setY(int index, double value) {
        yValues[index] = value;
    }

    public double leftBound() {
        return xValues[0];
    }

    public double rightBound() {
        return xValues[count - 1];
    }

    public int indexOfX(double x) {
        int index = 0;
        while (index <= count - 1) {
            if (xValues[index] == x) return index;
            else index++;
        }
        return -1;
    }

    public int indexOfY(double y) {
        int index = 0;
        while (index <= count - 1) {
            if (yValues[index] == y) return index;
            else index++;
        }
        return -1;
    }

    protected int floorIndexOfX(double x) {
        if (xValues[0] > x) return 0;
        else if (xValues[count - 1] < x) return count;
        else {
            for (int index = 0; ; index++) {
                if (xValues[index] == x) return index;
                else if (xValues[index] > x) return index - 1;
            }
        }
    }

    public double interpolate(double x, int floorIndex) {
        if (count == 1) {
            return yValues[0];
        } else {
            double leftX = getX(floorIndex - 1);
            double rightX = getX(floorIndex);
            double leftY = getY(floorIndex - 1);
            double rightY = getY(floorIndex);
            return interpolate(x, leftX, rightX, leftY, rightY);
        }
    }
    protected double extrapolateLeft(double x) {
        if (count == 1) return yValues[0];
        else
            return (yValues[0] + (((yValues[1] - yValues[0]) / (xValues[1] - xValues[0])) * (x - xValues[0])));
    }

    protected double extrapolateRight(double x) {
        if (count == 1) return yValues[0];
        else
            return (yValues[count - 2] + (((yValues[count - 1] - yValues[count - 2]) / (xValues[count - 1] - xValues[count - 2])) * (x - xValues[count - 2])));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("(").append(xValues[i]).append(";").append(yValues[i]).append(") ");
        }
        return sb.toString();
    }
    public boolean equals(Object o) {
        return this.getClass() == o.getClass() &&
                Arrays.equals(((ArrayTabulatedFunction) o).xValues, xValues) &&
                Arrays.equals(((ArrayTabulatedFunction) o).yValues, yValues);
    }
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < count; i++) {
            long xBits = Double.doubleToLongBits(xValues[i]);
            long yBits = Double.doubleToLongBits(yValues[i]);
            result = 31 * result + (int) (xBits ^ (xBits >>> 32));
            result = 31 * result + (int) (yBits ^ (yBits >>> 32));
        }
        return result;
    }
    public Object clone() {
        return new ArrayTabulatedFunction(xValues.clone(), yValues.clone());
    }
}

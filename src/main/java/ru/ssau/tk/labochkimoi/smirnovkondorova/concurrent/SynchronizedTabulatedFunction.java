package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction delegation;

    public SynchronizedTabulatedFunction(TabulatedFunction delegation
    ) {
        this.delegation = delegation;

    }

    @Override
    public int getCount() {
        synchronized (delegation) {
            return delegation.getCount();
        }
    }

    @Override
    public double getX(int index) {
        synchronized (delegation) {
            return delegation.getX(index);
        }
    }

    @Override
    public double getY(int index) {
        synchronized (delegation) {
            return delegation.getY(index);
        }
    }

    @Override
    public void setY(int index, double value) {
        synchronized (delegation) {
            delegation.setY(index, value);
        }
    }

    @Override
    public int indexOfX(double x) {
        synchronized (delegation) {
            return delegation.indexOfX(x);
        }
    }

    @Override
    public int indexOfY(double y) {
        synchronized (delegation) {
            return delegation.indexOfY(y);
        }
    }

    @Override
    public double rightBound() {
        synchronized (delegation) {
            return delegation.rightBound();
        }
    }

    @Override
    public double leftBound() {
        synchronized (delegation) {
            return delegation.leftBound();
        }
    }

    @Override/* не знаю, насколько это правильно но оно без ошибок и я очень хотела спать..*/
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private int i = 0;
            public boolean hasNext() {
                return (i < delegation.getCount());
            }
            public Point next() {
                if (hasNext()) {
                    Point point = new Point(delegation.getX(i), delegation.getY(i));
                    ++i;
                    return point;
                } else throw new NoSuchElementException();
            }
        };
    }

    @Override
    public double apply(double x) {
        synchronized (delegation) {
            return delegation.apply(x);
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction synchronizedFunction);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (delegation) {
            return operation.apply(this);
        }
    }
}
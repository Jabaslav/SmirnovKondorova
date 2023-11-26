package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import org.jetbrains.annotations.NotNull;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService;

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

    @Override
    public @NotNull Iterator<Point> iterator() {
        synchronized (delegation) {
            Point[] copy = TabulatedFunctionOperationService.asPoints(delegation);
            Iterator<Point> iterator = new Iterator<Point>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return (i < copy.length);
                }

                @Override
                public Point next() throws NoSuchElementException {
                    if (this.hasNext()) {
                        return copy[i++];
                    } else throw new NoSuchElementException();
                }
            };
            return iterator;
        }
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
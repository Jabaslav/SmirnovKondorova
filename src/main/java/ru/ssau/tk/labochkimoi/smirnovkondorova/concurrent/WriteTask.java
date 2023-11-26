package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

public class WriteTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;
    private final double value;

    public WriteTask(TabulatedFunction tabulatedFunction, double value)
    {
        this.tabulatedFunction = tabulatedFunction;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0, count = tabulatedFunction.getCount(); i<count;i++) {
            tabulatedFunction.setY(i, value);
            System.out.println("Writing for index " + i + " complete");
        }
    }
}

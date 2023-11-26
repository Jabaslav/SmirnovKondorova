package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

public class ReadTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;

    public ReadTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0, count = tabulatedFunction.getCount(); i < count; i++) {
            synchronized (tabulatedFunction) {
                System.out.println("After read: i = " + i + ", x = " + tabulatedFunction.getX(i) + ", y = " + tabulatedFunction.getY(i));
            }
        }
    }
}

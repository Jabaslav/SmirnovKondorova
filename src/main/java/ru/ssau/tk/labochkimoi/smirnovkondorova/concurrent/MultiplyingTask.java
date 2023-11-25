package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
public class MultiplyingTask implements Runnable{
    private TabulatedFunction tabulatedFunction;

    public MultiplyingTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            synchronized (tabulatedFunction) {
                tabulatedFunction.setY( i,tabulatedFunction.getY(i) * 2);}
        }

        System.out.println("Текущий поток (" + Thread.currentThread().getName() + ") закончил выполнение задачи.");
    }
}

package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.UnitFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction tabulatedFunction = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000,1000);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MultiplyingTask multiplyingTask = new MultiplyingTask(tabulatedFunction);
            Thread thread = new Thread(multiplyingTask);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        TimeUnit.SECONDS.sleep(2);

        System.out.println("Tabulated Function:");
        System.out.println(tabulatedFunction);
    }
}

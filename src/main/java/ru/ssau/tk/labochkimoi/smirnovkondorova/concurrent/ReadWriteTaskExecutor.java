package ru.ssau.tk.labochkimoi.smirnovkondorova.concurrent;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ConstantFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args)
    {
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new ConstantFunction(-1), 1, 1000, 1000);
        Thread thread1 = new Thread(new ReadTask(linkedListTabulatedFunction));
        Thread thread2 = new Thread(new WriteTask(linkedListTabulatedFunction, 0.5));

        thread1.start();
        thread2.start();
    }
}

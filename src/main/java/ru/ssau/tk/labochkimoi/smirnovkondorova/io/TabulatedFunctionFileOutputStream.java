package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args)
    {
        try(BufferedOutputStream array = new BufferedOutputStream(new FileOutputStream("output/arrayfunction.bin"));
            BufferedOutputStream linkedList = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"));)
        {
            double[] xVal = new double[]{1, 2, 3, 4, 5};
            double[] yVal = new double[]{1, 2, 3, 4, 5};
            LinkedListTabulatedFunction listFunction = new LinkedListTabulatedFunction(xVal, yVal);
            ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(xVal, yVal);

            FunctionsIO.writeTabulatedFunction(array, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedList, listFunction);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

package ru.ssau.tk.labochkimoi.smirnovkondorova.io;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        try (BufferedWriter arrayWriter = new BufferedWriter(new FileWriter("output/array function.txt"));
             BufferedWriter linkedListWriter = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {

            double[] xValue = {1, 2, 3, 4, 5};
            double[] yValue = {10, 20, 30, 40, 50};

            ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValue, yValue);
            LinkedListTabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(xValue, yValue);

            FunctionsIO.writeTabulatedFunction(arrayWriter, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedListWriter, linkedListFunction);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

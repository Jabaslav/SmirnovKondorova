package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try (
                BufferedReader arrayReader = new BufferedReader(new FileReader("input/function.txt"));
                BufferedReader linkedListReader = new BufferedReader(new FileReader("input/function.txt"))
        ) {
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(arrayReader, new ArrayTabulatedFunctionFactory());
            TabulatedFunction linkedListFunction = FunctionsIO.readTabulatedFunction(linkedListReader, new LinkedListTabulatedFunctionFactory());

            System.out.println("ArrayTabulatedFunction:");
            System.out.println(arrayFunction.toString());

            System.out.println("\nLinkedListTabulatedFunction:");
            System.out.println(linkedListFunction.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

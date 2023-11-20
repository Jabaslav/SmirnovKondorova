package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.DifferentialOperator;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input/binary function.bin"))) {

            ArrayTabulatedFunction arrayTabulatedFunction = (ArrayTabulatedFunction) FunctionsIO.readTabulatedFunction(bufferedInputStream, new ArrayTabulatedFunctionFactory());
            System.out.println(arrayTabulatedFunction.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер и значения функции");
            LinkedListTabulatedFunction linkedListTabulatedFunction = (LinkedListTabulatedFunction) FunctionsIO.readTabulatedFunction(buffer, new LinkedListTabulatedFunctionFactory());
            TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
            System.out.println(operator.derive(linkedListTabulatedFunction).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

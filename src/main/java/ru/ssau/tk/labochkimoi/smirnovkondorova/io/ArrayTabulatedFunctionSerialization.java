package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedDifferentialOperator;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args){
        double[] xValue = {1, 2, 3, 4, 5};
        double[] yValue = {10, 20, 30, 40, 50};
        TabulatedFunction arrayFunc = new ArrayTabulatedFunction(xValue, yValue);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
        TabulatedFunction firstDerivative = differentialOperator.derive(arrayFunc);
        TabulatedFunction secondDerivative = differentialOperator.derive(firstDerivative);

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output/serialized_array_functions.bin"))) {
            FunctionsIO.serialize(outputStream, arrayFunc);
            FunctionsIO.serialize(outputStream, firstDerivative);
            FunctionsIO.serialize(outputStream, secondDerivative);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("output/serialized_array_functions.bin"))) {
            System.out.println(FunctionsIO.deserialize(inputStream));
            System.out.println(FunctionsIO.deserialize(inputStream));
            System.out.println(FunctionsIO.deserialize(inputStream));

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

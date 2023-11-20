package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialize {
    public static void main(String[] args) {
        try (BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {
            double[] xVal = {1, 2, 3, 4, 5};
            double[] yVal = {1, 2, 3, 4, 5};
            LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xVal, yVal);
            TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
            LinkedListTabulatedFunction firstDerivative = (LinkedListTabulatedFunction) differentialOperator.derive(linkedListTabulatedFunction);
            LinkedListTabulatedFunction secondDerivative = (LinkedListTabulatedFunction) differentialOperator.derive(firstDerivative);
            FunctionsIO.serialize(buffer, linkedListTabulatedFunction);
            FunctionsIO.serialize(buffer, firstDerivative);
            FunctionsIO.serialize(buffer, secondDerivative);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedInputStream newBuffer = new BufferedInputStream(new FileInputStream("output/serialized linked list functions.bin"));
            System.out.println(FunctionsIO.deserialize(newBuffer).toString());
            System.out.println(FunctionsIO.deserialize(newBuffer).toString());
            System.out.println(FunctionsIO.deserialize(newBuffer).toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

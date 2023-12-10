package ru.ssau.tk.labochkimoi.smirnovkondorova.io;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.Point;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;

public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());

        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }

        printWriter.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        try {
            int count = Integer.parseInt(reader.readLine());

            double[] xValues = new double[count];
            double[] yValues = new double[count];

            NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));

            for (int i = 0; i < count; i++) {
                String line = reader.readLine();

                String[] parts = line.split(" ");

                xValues[i] = numberFormat.parse(parts[0]).doubleValue();
                yValues[i] = numberFormat.parse(parts[1]).doubleValue();
            }

            return factory.create(xValues, yValues);

        } catch (ParseException e) {
            throw new IOException("Error parsing double values.", e);
        }
    }

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(function.getCount());
        for (Point point : function) {
            dataOutputStream.writeDouble(point.x);
            dataOutputStream.writeDouble(point.y);
        }
        dataOutputStream.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int count = dataInputStream.readInt();
        double[] xVal = new double[count];
        double[] yVal = new double[count];
        for (int i = 0; i < count; i++) {
            xVal[i] = dataInputStream.readDouble();
            yVal[i] = dataInputStream.readDouble();
        }

        return factory.create(xVal, yVal);
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(function);
        objectOutputStream.flush();
    }

    public static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        return ((TabulatedFunction) objectInputStream.readObject());
    }
}

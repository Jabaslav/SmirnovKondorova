package ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.*;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;


public class FunctionBasedCreation extends JFrame {
    private JComboBox mathFunctionsList = new JComboBox(new String[]{"Единичная функция", "Квадратная функция", "Косинус", "Натуральный Логарифм", "Нулевая функция", "Тождественная функция" });
    private JTextField pointsField;
    private JTextField intervalBegin;
    private JTextField intervalEnd;
    HashMap<String, MathFunction> mathFunctionMap;

    private LinkedListTabulatedFunction createdFunction;

    public FunctionBasedCreation() {
        this.setTitle("Создание на базе функции");
        this.setSize(470, 300);

        mathFunctionMap = new HashMap<String, MathFunction>();
        mathFunctionMap.put("Квадратная функция", new SqrFunction());
        mathFunctionMap.put("Тождественная функция", new IdentityFunction());
        mathFunctionMap.put("Натуральный логарифм", new NaturalLogFunction());
        mathFunctionMap.put("Нулевая функция", new ZeroFunction());
        mathFunctionMap.put("Единичная функция", new UnitFunction());
        mathFunctionMap.put("Косинус", new CosFunction());

        this.setLayout(null);
        JLabel pointsF = new JLabel("Число точек:");
        pointsF.setBounds(5, 10, 250, 30);
        JLabel intervalB = new JLabel("Начало интервала:");
        intervalB.setBounds(5, 40, 250, 30);
        JLabel intervalE = new JLabel("Конец интервала:");
        intervalE.setBounds(5, 70, 150, 30);
        pointsField = new JTextField(10);
        pointsField.setBounds(250, 10, 200, 20);
        intervalBegin = new JTextField(10);
        intervalBegin.setBounds(250, 40, 200, 20);
        intervalEnd = new JTextField(10);
        intervalEnd.setBounds(250, 70, 200, 20);
        this.add(pointsF);
        this.add(intervalB);
        this.add(intervalE);
        this.add(pointsField);
        this.add(intervalBegin);
        this.add(intervalEnd);

        JLabel pickMathFunction = new JLabel("Выберите функцию");
        pickMathFunction.setBounds(5, 100, 200, 30);
        mathFunctionsList.setBounds(250, 100, 200, 30);
        this.add(pickMathFunction);
        this.add(mathFunctionsList);

        JButton createFunction = new JButton("Создать");
        createFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTabulatedFunction();
            }
        });
        createFunction.setBounds(5, 150, 440, 100);
        createFunction.setBackground(Color.LIGHT_GRAY);
        this.add(createFunction);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void createTabulatedFunction() {
        try {
            String mathFunction = (String) mathFunctionsList.getSelectedItem();
            int count = Integer.parseInt(pointsField.getText());
            if (count < 2) {
                showError("Некорректное число точек");
                return;

            }

            double intervalB = Double.parseDouble(intervalBegin.getText());
            double intervalE = Double.parseDouble(intervalEnd.getText());

            createdFunction = new LinkedListTabulatedFunctionFactory().create(mathFunctionMap.get(mathFunction), intervalB, intervalE, count);

             System.out.println("LinkedListTabulatedFunction created: " + createdFunction);
             dispose();
        }
        catch (NumberFormatException e)
        {
            showError("Некорректный формат ввода");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            new FunctionBasedCreation().setVisible(true);
        });
    }

    public double[] getxValues(){
        double[] xValues = new double[createdFunction.getCount()];
        for (int i = 0; i < xValues.length; i++) {
            xValues[i] = createdFunction.getX(i);
        }
        return xValues;
    }

    public double[] getyValues(){
        double[] yValues = new double[createdFunction.getCount()];
        for (int i = 0; i < yValues.length; i++) {
            yValues[i] = createdFunction.getY(i);
        }
        return yValues;
    }
}

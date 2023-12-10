package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;


public class FunctionBasedCreation extends JDialog {
    private JComboBox mathFunctionsList = new JComboBox(new String[]{"Единичная функция", "Квадратная функция", "Косинус", "Натуральный Логарифм", "Нулевая функция", "Тождественная функция" });
    private JTextField pointsField;
    private JTextField intervalBegin;
    private JTextField intervalEnd;
    HashMap<String, MathFunction> mathFunctionMap;

    public FunctionBasedCreation(MainFrame mainFrame) {
        setTitle("Создание на базе функции");
        setSize(470, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        mathFunctionMap = new HashMap<String, MathFunction>();
        mathFunctionMap.put("Квадратная функция", new SqrFunction());
        mathFunctionMap.put("Тождественная функция", new IdentityFunction());
        mathFunctionMap.put("Натуральный логарифм", new NaturalLogFunction());
        mathFunctionMap.put("Нулевая функция", new ZeroFunction());
        mathFunctionMap.put("Единичная функция", new UnitFunction());
        mathFunctionMap.put("Косинус", new CosFunction());


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

        JButton createFunction = new JButton("Создать");
        createFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTabulatedFunction(mainFrame);
            }
        });
        createFunction.setBounds(5, 150, 440, 100);
        createFunction.setBackground(Color.LIGHT_GRAY);

        JLabel pickMathFunction = new JLabel("Выберите функцию");
        pickMathFunction.setBounds(5, 100, 200, 30);
        mathFunctionsList.setBounds(250, 100, 200, 30);

        add(pointsF);
        add(intervalB);
        add(intervalE);
        add(pointsField);
        add(intervalBegin);
        add(intervalEnd);
        add(pickMathFunction);
        add(mathFunctionsList);


        this.add(createFunction);

        setVisible(true);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void createTabulatedFunction(MainFrame mainFrame) {
        try {
            String mathFunction = (String) mathFunctionsList.getSelectedItem();
            int count = Integer.parseInt(pointsField.getText());
            if (count < 2) {
                showError("Некорректное число точек");
                return;

            }

            double intervalB = Double.parseDouble(intervalBegin.getText());
            double intervalE = Double.parseDouble(intervalEnd.getText());

            mainFrame.database.add(mainFrame.functionFactory.create(mathFunctionMap.get(mathFunction), intervalB, intervalE, count));
            mainFrame.functionList.update(mainFrame);
            dispose();
        }
        catch (NumberFormatException e)
        {
            showError("Некорректный формат ввода");
        }
    }
}

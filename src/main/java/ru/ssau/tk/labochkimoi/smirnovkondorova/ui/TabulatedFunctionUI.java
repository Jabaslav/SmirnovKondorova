package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabulatedFunctionUI extends JDialog {

    private JTextField pointsField;
    private JTable table;
    private DefaultTableModel tableModel;
    private double[] xValues;
    private double[] yValues;

    public TabulatedFunctionUI(MainFrame mainFrame) {
        setTitle("Tabulated Function Creator");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        pointsField = new JTextField(10);
        JButton createButton = new JButton("Create");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTabulatedFunction(mainFrame);
            }
        });

        tableModel = new DefaultTableModel();
        // Создайте и настройте JTable
        tableModel.addColumn("X");
        tableModel.addColumn("Y");
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        // Добавляем компоненты на форму
        add(createInputPanel(), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(createButton, BorderLayout.SOUTH);
        setVisible(true);
    }
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Number of Points:"));
        inputPanel.add(pointsField);
        return inputPanel;
    }

    private void createTabulatedFunction(MainFrame mainFrame) {
        try {
            int numberOfPoints = Integer.parseInt(pointsField.getText());
            if (numberOfPoints < 2) {
                ExceptionProcessor.showError("Please enter a valid number of points.");
                return;
            }

            tableModel.setRowCount(0);

            for (int i = 0; i < numberOfPoints; i++) {
                Object[] rowData = new Object[2];
                rowData[0] = JOptionPane.showInputDialog("Enter X value for point " + (i + 1));
                rowData[1] = JOptionPane.showInputDialog("Enter Y value for point " + (i + 1));
                tableModel.addRow(rowData);
            }

            // Создаем табулированную функцию с использованием фабрики
            TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
            xValues = new double[numberOfPoints];
            yValues = new double[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                xValues[i] = Double.parseDouble(tableModel.getValueAt(i, 0).toString());
                yValues[i] = Double.parseDouble(tableModel.getValueAt(i, 1).toString());
            }

             mainFrame.database.add(factory.create(xValues, yValues));


            // Закрываем окно
            dispose();
        } catch (NumberFormatException ex) {
            showError("Некорректный ввод. Попробуйте еще раз");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public double[] fillXValues(double[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(tableModel.getValueAt(i, 0).toString());
        }
        return values;
    }

    public double[] fillYValues(double[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(tableModel.getValueAt(i, 1).toString());
        }
        return values;
    }
    public double[] getxValues(){
        return xValues;
    }

    public double[] getyValues(){
        return yValues;
    }
}

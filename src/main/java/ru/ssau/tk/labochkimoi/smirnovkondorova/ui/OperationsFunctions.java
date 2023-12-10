package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService.Operation.*;
import static ru.ssau.tk.labochkimoi.smirnovkondorova.operations.TabulatedFunctionOperationService.Operation.divide;

public class OperationsFunctions extends JFrame{


    private JTable table;
    private DefaultTableModel tableModel;
    private TabulatedFunctionUI functionUI1;
    private TabulatedFunctionUI functionUI2;
    private FunctionBasedCreation functionUI3;
    private FunctionBasedCreation functionUI4;

    public OperationsFunctions() {
        setTitle("Function Operations");
        setSize(1600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Инициализация компонентов
        tableModel = new DefaultTableModel();
        tableModel.addColumn("X1");
        tableModel.addColumn("Y1");
        tableModel.addColumn("X2");
        tableModel.addColumn("Y2");
        table = new JTable(tableModel);
        functionUI1 = new TabulatedFunctionUI();
        functionUI2 = new TabulatedFunctionUI();
        //functionUI3 = new FunctionBasedCreation(this);
        //functionUI4 = new FunctionBasedCreation(this);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        JButton addFunctionButton1 = new JButton("AddFunction1");
        JButton addFunctionButton2 = new JButton("AddFunction2");
        JButton addFunctionButton3 = new JButton("AddFunction3");
        JButton addFunctionButton4 = new JButton("AddFunction4");
        JButton printValuesButton = new JButton("Print");

        // Добавление слушателей кнопок
        addFunctionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    functionUI1.setVisible(true);
                });
            }
        });

        addFunctionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    functionUI3.setVisible(true);
                });
            }
        });

        printValuesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double[] xValues1 = functionUI1.getxValues();
                double[] yValues1 = functionUI1.getyValues();

                double[] xValues2 = functionUI2.getxValues();
                double[] yValues2 = functionUI2.getyValues();

                //double[] xValues10 = functionUI3.getxValues();
                //double[] yValues10 = functionUI3.getyValues();

                //double[] xValues20 = functionUI4.getxValues();
                //double[] yValues20 = functionUI4.getyValues();

                //if(tableModel.getRowCount()>0) tableModel.removeRow(4);
                for (int i = 0; i < xValues1.length; i++) {
                    Object[] rowData = new Object[4];
                    rowData[0] = xValues1[i];
                    rowData[1] = yValues1[i];
                    ;
                    rowData[2] = xValues2[i];
                    ;
                    rowData[3] = yValues2[i];
                    tableModel.addRow(rowData);
                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(add);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(subtract);
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(multiply);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation(divide);
            }
        });

        // Расположение компонентов
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(addFunctionButton1);
        buttonPanel.add(addFunctionButton2);
        buttonPanel.add(addFunctionButton3);
        buttonPanel.add(addFunctionButton4);
        buttonPanel.add(printValuesButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateTable(double[] xValues, double[] yValues) {
        // Очистка таблицы
        tableModel.setRowCount(0);

        // Заполнение таблицы новыми значениями
        for (int i = 0; i < xValues.length; i++) {
            Object[] rowData = {xValues[i], yValues[i]};
            tableModel.addRow(rowData);
        }
    }

    private void performOperation(TabulatedFunctionOperationService.Operation operation) {
        // Получение данных из таблиц функций
        double[] xValues1 = functionUI1.getxValues();
        double[] yValues1 = functionUI1.getyValues();

        double[] xValues2 = functionUI2.getxValues();
        double[] yValues2 = functionUI2.getyValues();

       // double[] xValues10 = functionUI3.getxValues();
        //double[] yValues10 = functionUI3.getyValues();

        //double[] xValues20 = functionUI4.getxValues();
        //double[] yValues20 = functionUI4.getyValues();

        // Выполнение операции
        TabulatedFunctionOperationService operationService = new TabulatedFunctionOperationService();
        TabulatedFunction resultFunction;

        for (int i = 0; i < xValues1.length; i++) {
            Object[] rowData = new Object[4];
            rowData[0] = xValues1[i];
            rowData[1] = yValues1[i];
            rowData[2] = xValues2[i];
            rowData[3] = yValues2[i];
            tableModel.addRow(rowData);
        }

        switch (operation) {
            case add:
                resultFunction = operationService.add(
                        operationService.getFactory().create(xValues1, yValues1),
                        operationService.getFactory().create(xValues2, yValues2)
                );
                break;
            case subtract:
                resultFunction = operationService.subtract(
                        operationService.getFactory().create(xValues1, yValues1),
                        operationService.getFactory().create(xValues2, yValues2)
                );
                break;
            case multiply:
                resultFunction = operationService.multiply(
                        operationService.getFactory().create(xValues1, yValues1),
                        operationService.getFactory().create(xValues2, yValues2)
                );
                break;
            case divide:
                resultFunction = operationService.divide(
                        operationService.getFactory().create(xValues1, yValues1),
                        operationService.getFactory().create(xValues2, yValues2)
                );
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }

        // Отображение результата в новом окне
        showResultTable(resultFunction);
    }

    private void showResultTable(TabulatedFunction resultFunction) {
        ResultTableUI resultTableUI = new ResultTableUI(resultFunction);
        SwingUtilities.invokeLater(() -> {
            resultTableUI.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OperationsFunctions().setVisible(true);
        });
    }
}

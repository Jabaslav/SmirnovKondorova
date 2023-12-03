package ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabulatedFunctionUI extends JFrame {

    private JTextField pointsField;
    private JTable table;
    private DefaultTableModel tableModel;

    public TabulatedFunctionUI() {
        setTitle("Tabulated Function Creator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pointsField = new JTextField(10);
        JButton createButton = new JButton("Create");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTabulatedFunction();
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
    }
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Number of Points:"));
        inputPanel.add(pointsField);
        return inputPanel;
    }

    private void createTabulatedFunction() {
        try {
            int numberOfPoints = Integer.parseInt(pointsField.getText());
            if (numberOfPoints <= 0) {
                showError("Please enter a valid number of points.");
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
            double[] xValues = new double[numberOfPoints];
            double[] yValues = new double[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                xValues[i] = Double.parseDouble(tableModel.getValueAt(i, 0).toString());
                yValues[i] = Double.parseDouble(tableModel.getValueAt(i, 1).toString());
            }

            TabulatedFunction tabulatedFunction = factory.create(xValues, yValues);
            System.out.println("Tabulated Function created: " + tabulatedFunction);

            // Закрываем окно
            dispose();
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter a valid number.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TabulatedFunctionUI().setVisible(true);
        });
    }
}
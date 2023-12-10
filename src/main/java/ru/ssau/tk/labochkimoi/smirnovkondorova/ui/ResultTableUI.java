package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.TabulatedFunction;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultTableUI extends JFrame {
    private TabulatedFunction resultFunction;
    private JTable table;
    private DefaultTableModel tableModel;

    public ResultTableUI(TabulatedFunction resultFunction) {
        setTitle("Result Function");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Инициализация компонентов
        tableModel = new DefaultTableModel();
        tableModel.addColumn("X");
        tableModel.addColumn("Y");
        table = new JTable(tableModel);

        // Заполнение таблицы результатами
        for (int i = 0; i < resultFunction.getCount(); i++) {
            Object[] rowData = {resultFunction.getX(i), resultFunction.getY(i)};
            tableModel.addRow(rowData);
        }

        // Расположение компонентов
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}


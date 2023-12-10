package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import javax.swing.*;

public class ExpandedFunctionTable extends JDialog {
    private JTable table;
    public ExpandedFunctionTable(FunctionDatabase.Node node) {
        String[] tableHeader = new String[] {"№", "X", "Y"};
        String[][] tableData = new String[node.tabulatedFunction.getCount()][3];
        for (int i = 0; i<node.tabulatedFunction.getCount(); i++)
        {
            tableData[i][0] = Integer.toString(i);
            tableData[i][1]= Double.toString(node.tabulatedFunction.getX(i));
            tableData[i][2]=Double.toString(node.tabulatedFunction.getY(i));
        }
        table = new JTable(tableData, tableHeader);
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);

        setVisible(true);
    }

    public void update(){
        table.removeAll();
        table.revalidate();
    }
}

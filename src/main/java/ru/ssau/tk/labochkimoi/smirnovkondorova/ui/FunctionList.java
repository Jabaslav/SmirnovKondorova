package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FunctionList extends JScrollPane {
    public JList<FunctionDatabase.Node> list = new JList<>();
    private DefaultListModel<FunctionDatabase.Node> model = new DefaultListModel<>();


    public FunctionList(MainFrame mainFrame) {
        setName("Список функций");
        setSize(500, 200);
        setLocation(0, 0);


        for (int i = 0; i < mainFrame.database.getSize(); i++) {
            model.addElement(mainFrame.database.getNode(i));
            list.setModel(model);
        }

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //new ExpandedFunctionTable(list.getSelectedValue());
                //list.clearSelection();
            }
        });

        add(list);

        list.setSize(500, 300);



        setVisible(true);
    }

    public void update(MainFrame mainFrame) {
        model.clear();
        for (int i = 0; i < mainFrame.database.getSize(); i++) {
            model.addElement(mainFrame.database.getNode(i));
            list.setModel(model);
        }
    }
}

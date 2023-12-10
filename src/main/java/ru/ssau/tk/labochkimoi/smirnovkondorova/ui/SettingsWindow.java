package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.LinkedListTabulatedFunctionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JDialog {
    public SettingsWindow(MainFrame mainFrame)
    {
        JLabel functionTypeLabel = new JLabel("Выберите тип создаваемой функции:");
        functionTypeLabel.setBounds(50, 5, 300, 30);
        DefaultButton arraySelectButton = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.functionFactory = new ArrayTabulatedFunctionFactory();
                dispose();
            }
        }, "Array tabulated function");
        DefaultButton linkedListSelectButton = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.functionFactory = new LinkedListTabulatedFunctionFactory();
                dispose();
            }
        }, "Linked list tabulated function");


        setLayout(null);
        setSize(327, 200);
        arraySelectButton.setLocation(5, 40);
        linkedListSelectButton.setLocation(5, 100);

        add(functionTypeLabel);
        add(arraySelectButton);
        add(linkedListSelectButton);
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
    }
//    public static void main(String[] args)
//    {
//        SwingUtilities.invokeLater(() -> {
//            new SettingsWindow().setVisible(true);
//        });
//    }
}

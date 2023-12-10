package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFunctionWindow extends JDialog {
    public CreateFunctionWindow(MainFrame mainFrame) {
        JLabel creationType = new JLabel("Выберите способ задания функции:");

        DefaultButton arrayBased = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TabulatedFunctionUI(mainFrame);
                dispose();
            }
        },
                "На основе массива");

        DefaultButton mathFunctionBased = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FunctionBasedCreation(mainFrame);
                dispose();
            }},
                "На основе математической функции");

        setBounds(500, 500, 327, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);


        creationType.setBounds(50, 5, 300, 30);
        arrayBased.setLocation(5, 40);
        mathFunctionBased.setLocation(5, 100);

        add(creationType);
        add(arrayBased);
        add(mathFunctionBased);

        setVisible(true);
    }
}

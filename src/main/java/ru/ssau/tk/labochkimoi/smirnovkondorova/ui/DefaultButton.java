package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DefaultButton extends JButton {
    public DefaultButton(ActionListener actionListener, String buttonName)
    {
        setText(buttonName);
        setBounds(0, 0, 300, 50);
        addActionListener(actionListener);
        setBackground(Color.white);
        setForeground(Color.black);
    }
}

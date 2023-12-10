package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import javax.swing.*;

public class ExceptionProcessor {
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

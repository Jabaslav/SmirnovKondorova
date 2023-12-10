package ru.ssau.tk.labochkimoi.smirnovkondorova.ui;

import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame mainFrame = this;
    public FunctionDatabase database = new FunctionDatabase();
    public TabulatedFunctionFactory functionFactory = new ArrayTabulatedFunctionFactory();
    public FunctionList functionList;

    public MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setTitle("Главное окно");
        functionList = new FunctionList(mainFrame);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        DefaultButton createFunction = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateFunctionWindow(mainFrame);
            }
        }, "Создать функцию");

        DefaultButton operationWithFunctions = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (functionList.list.getSelectedValue() == null) {
                    ExceptionProcessor.showError("Не выбрано ни одной функции");
                } else {
                    new ExpandedFunctionTable(functionList.list.getSelectedValue());
                    functionList.list.clearSelection();
                }
            }
        }, "Вывести таблицу");

        DefaultButton differentialOperator = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database.add(new ArrayTabulatedFunction(new double[]{1, 3, 5}, new double[]{2, 4, 6}));
                functionList.update(mainFrame);
            }
        }, "Добавить функцию");

        DefaultButton settings = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsWindow(mainFrame);
            }
        }, "Настройки");


        DefaultButton loadFunction = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionList.update(mainFrame);
            }
        }, "Загрузить функцию");

        DefaultButton saveFunction = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionList.update(mainFrame);
            }
        }, "Сохранить функцию");

        DefaultButton deleteFunction = new DefaultButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (functionList.list.getSelectedValue() == null) {
                    ExceptionProcessor.showError("Не выбрано ни одной функции");
                } else {
                    database.delete(functionList.list.getSelectedValue());
                    functionList.update(mainFrame);
                    functionList.list.clearSelection();
                }
            }
        }, "Удалить функцию");


        createFunction.setLocation(10, 30);
        operationWithFunctions.setLocation(10, 90);
        differentialOperator.setLocation(10, 150);
        settings.setLocation(10, 210);
        functionList.setLocation(10, 270);
        loadFunction.setLocation(550, 270);
        saveFunction.setLocation(550, 330);
        deleteFunction.setLocation(550, 390);


        add(createFunction);

        add(operationWithFunctions);

        add(differentialOperator);

        add(settings);

        add(functionList);

        add(loadFunction);

        add(saveFunction);

        add(deleteFunction);


        revalidate();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}

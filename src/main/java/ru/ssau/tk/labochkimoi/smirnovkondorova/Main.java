package ru.ssau.tk.labochkimoi.smirnovkondorova;
import ru.ssau.tk.labochkimoi.smirnovkondorova.functions.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IdentityFunction o = new IdentityFunction();
        System.out.println(o.apply(12.12d));
    }
}
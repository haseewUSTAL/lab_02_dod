package ru.university.lab2.numbers;

/**
 * Задание № 2 — Вещественная арифметика
 */
public class Task02RealArithmetic {

    public void run() {
        testDoublePrecision();
        testSpecialValues();
        testNanBehavior();
        testRoundingComparison();
    }

    private void testDoublePrecision() {
        System.out.println("--- 1. Floating Point Precision Issue ---");
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;
        System.out.println("0.1 + 0.2 = " + sum);
        System.out.println("0.1 + 0.2 == 0.3? " + (sum == 0.3));
        // Комментарий: Числа с плавающей точкой хранятся в двоичном формате IEEE 754.
        // Десятичные дроби вроде 0.1 и 0.2 не могут быть точно представлены в двоичном виде,
        // поэтому возникают небольшие погрешности округления.
    }

    private void testSpecialValues() {
        System.out.println("\n--- 2. Special Values (Infinity and Zero) ---");
        double posInf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double zeroDivZero = 0.0 / 0.0;

        System.out.println("1.0 / 0.0 = " + posInf);
        System.out.println("-1.0 / 0.0 = " + negInf);
        System.out.println("0.0 / 0.0 = " + zeroDivZero);
        // Комментарий: В отличие от целочисленного деления, деление double на 0.0
        // не вызывает ArithmeticException, а возвращает специальные значения IEEE 754:
        // Infinity (бесконечность) или NaN (Not a Number).
    }

    private void testNanBehavior() {
        System.out.println("\n--- 3. NaN Behavior ---");
        double nan = Double.NaN;

        System.out.println("NaN == NaN? " + (nan == nan));
        System.out.println("Double.isNaN(NaN)? " + Double.isNaN(nan));
        System.out.println("NaN > 0? " + (nan > 0));
        System.out.println("NaN < 0? " + (nan < 0));
        // Комментарий: Значение NaN по стандарту не равно ничему, даже самому себе.
        // Любые сравнения (>, <, ==) с NaN всегда возвращают false.
        // Для проверки используется специальный метод Double.isNaN().
    }

    private void testRoundingComparison() {
        System.out.println("\n--- 4. Safe Double Comparison ---");
        double x = 0.1 + 0.2;
        double y = 0.3;
        double epsilon = 1e-9; // Допустимая погрешность (10^-9)

        boolean isEqual = Math.abs(x - y) < epsilon;
        System.out.println("Is |0.1 + 0.2 - 0.3| < 1e-9? " + isEqual);
        // Комментарий: Вещественные числа нельзя сравнивать через '=='.
        // Правильный способ — проверить, что модуль их разности меньше заданного эпсилон.
    }
}
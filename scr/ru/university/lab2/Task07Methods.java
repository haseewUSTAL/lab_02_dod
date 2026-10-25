package ru.university.lab2;

import java.util.Arrays;

/**
 * Задание № 7 — Методы и передача аргументов
 * (Перегрузка, varargs, итеративная и рекурсивная степень, анализ производительности)
 */
public class Task07Methods {

    public void run() {
        System.out.println("--- 1. Method Overloading ---");
        testOverloading();

        System.out.println("\n--- 2. Varargs ---");
        testVarargs();

        System.out.println("\n--- 3. Power Calculation (Iterative vs Recursive) ---");
        testPower();
    }

    // 1. Перегруженные методы print для разных типов данных
    public void print(int val) {
        System.out.println("print(int): " + val);
    }

    public void print(double val) {
        System.out.println("print(double): " + val);
    }

    public void print(String val) {
        System.out.println("print(String): " + val);
    }

    public void print(int[] arr) {
        System.out.println("print(int[]): " + Arrays.toString(arr));
    }

    private void testOverloading() {
        print(42);
        print(3.14159);
        print("Java Programming");
        print(new int[]{10, 20, 30});
    }

    // 2. Метод с varargs для вычисления суммы
    public int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    private void testVarargs() {
        System.out.println("Sum with 0 arguments: " + sum());
        System.out.println("Sum with 3 arguments (5, 10, 15): " + sum(5, 10, 15));
        int[] arrayArg = {1, 2, 3, 4, 5};
        System.out.println("Sum with passed array: " + sum(arrayArg));
    }

    // 3. Итеративное возведение в степень (без Math.pow)
    public long powerIterative(int base, int exponent) {
        if (exponent < 0) throw new IllegalArgumentException("Exponent must be non-negative");
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // 3. Рекурсивное возведение в степень (без Math.pow)
    public long powerRecursive(int base, int exponent) {
        if (exponent < 0) throw new IllegalArgumentException("Exponent must be non-negative");
        if (exponent == 0) return 1;
        return base * powerRecursive(base, exponent - 1);
    }

    /**
     * 4. Гипотеза о производительности:
     * Итеративная реализация (powerIterative) будет работать быстрее рекурсивной (powerRecursive).
     *
     * Обоснование:
     * - При рекурсивном вызове на каждый шаг создается новый фрейм стека (stack frame) для хранения адреса возврата и локальных переменных, что создает накладные расходы на работу с памятью.
     * - Итеративный подход работает в рамках одного стекового фрейма, используя простой переход по циклу, что эффективнее по времени выполнения и потреблению памяти.
     */
    private void testPower() {
        int base = 2;
        for (int exp = 0; exp <= 5; exp++) {
            long iter = powerIterative(base, exp);
            long rec = powerRecursive(base, exp);
            double mathPow = Math.pow(base, exp);
            System.out.println(base + "^" + exp + " -> Iter: " + iter + ", Recur: " + rec + ", Math.pow: " + (long)mathPow);
        }
    }
}
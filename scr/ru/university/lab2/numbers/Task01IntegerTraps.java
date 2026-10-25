package ru.university.lab2.numbers;

/**
 * Задание № 1 — Целочисленные ловушки
 */
public class Task01IntegerTraps {

    public void run() {
        printMinMax();
        testOverflowAddition();
        testMultiplication();
        testDivisionAndModulo();
        testLongToIntCast();
        testCharArithmetic();
        testSafeAddition();
    }

    private void printMinMax() {
        System.out.println("--- 1. Min and Max values ---");
        System.out.println("Byte: min = " + Byte.MIN_VALUE + ", max = " + Byte.MAX_VALUE);
        System.out.println("Short: min = " + Short.MIN_VALUE + ", max = " + Short.MAX_VALUE);
        System.out.println("Int: min = " + Integer.MIN_VALUE + ", max = " + Integer.MAX_VALUE);
        System.out.println("Long: min = " + Long.MIN_VALUE + ", max = " + Long.MAX_VALUE);
        // Комментарий: Числовые примитивные типы в Java имеют фиксированный размер в байтах
        // и хранятся в памяти по стандарту дополнения до двух, поэтому их диапазоны строго ограничены.
    }

    private void testOverflowAddition() {
        System.out.println("\n--- 2. Integer Overflow on Addition ---");
        int max = Integer.MAX_VALUE;
        int overflowed = max + 1;
        System.out.println("Integer.MAX_VALUE: " + max);
        System.out.println("Integer.MAX_VALUE + 1: " + overflowed);
        // Комментарий: Происходит переполнение (overflow). При выходе за границу максимального
        // значения битовая маска циклически уходит в минимальное отрицательное число.
    }

    private void testMultiplication() {
        System.out.println("\n--- 3. Multiplication Overflow ---");
        int intRes = Integer.MAX_VALUE * 2;
        long longResUncasted = Integer.MAX_VALUE * 2;
        long longResCorrect = (long) Integer.MAX_VALUE * 2;

        System.out.println("Integer.MAX_VALUE * 2 (int): " + intRes);
        System.out.println("Integer.MAX_VALUE * 2 (long uncasted): " + longResUncasted);
        System.out.println("Integer.MAX_VALUE * 2 (long casted): " + longResCorrect);
        // Комментарий: В первом и втором случае умножение выполняется в 32-битной арифметике int,
        // что приводит к переполнению еще до расширения до long. В третьем случае явное приведение
        // одного из операндов к long переключает вычисление на 64-битную арифметику.
    }

    private void testDivisionAndModulo() {
        System.out.println("\n--- 4. Division and Modulo ---");
        System.out.println("5 / 2 = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        System.out.println("5 % 2 = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
        // Комментарий: Целочисленное деление в Java всегда отбрасывает дробную часть (округление к нулю).
        // Знак остатка от деления всегда совпадает со знаком делимого (первого операнда).
    }

    private void testLongToIntCast() {
        System.out.println("\n--- 5. Long to Int Cast ---");
        long largeLong = 3_000_000_000L;
        int castedInt = (int) largeLong;
        System.out.println("Original long: " + largeLong);
        System.out.println("Casted to int: " + castedInt);
        // Комментарий: Принудительное сужающее приведение типа long к int отбрасывает
        // старшие 32 бита, из-за чего значение искажается, а знак числа может неожиданно поменяться.
    }

    private void testCharArithmetic() {
        System.out.println("\n--- 6. Char Arithmetic ---");
        char ch = 'A';
        char nextCh = (char) (ch + 1);
        char sumCh = (char) ('А' + 'Б');
        System.out.println("Next letter after A: " + nextCh);
        System.out.println("Sum of 'А' and 'Б' as char: " + sumCh + ", as code: " + (int) sumCh);
        // Комментарий: Тип char в Java представляет собой 16-битное беззнаковое целое число (код UTF-16),
        // поэтому над ним разрешены стандартные арифметические операции.
    }

    private void testSafeAddition() {
        System.out.println("\n--- 7. Safe Addition ---");
        int a = 2_000_000_000;
        int b = 500_000_000;
        int c = 100;
        int d = 200;

        System.out.println(a + " + " + b + " overflows? " + checkOverflow(a, b));
        System.out.println(c + " + " + d + " overflows? " + checkOverflow(c, d));
    }

    private boolean checkOverflow(int x, int y) {
        long sum = (long) x + y;
        return sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE;
        // Комментарий: Чтобы безопасно проверить переполнение двух int без исключений,
        // результат аккумулируется в типе long, после чего сравнивается с границами диапазона int.
    }
}
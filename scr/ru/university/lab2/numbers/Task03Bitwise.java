package ru.university.lab2.numbers;

/**
 * Задание № 3 — Побитовые операции
 */
public class Task03Bitwise {

    public void run() {
        testBasicBitwise();
        testShifts();
        testUnsignedShift();
        testSwapWithoutTemp();
    }

    private void testBasicBitwise() {
        System.out.println("--- 1. Basic Bitwise Operations ---");
        int a = 0b1100; // 12
        int b = 0b1010; // 10

        System.out.println("a (12) = " + Integer.toBinaryString(a));
        System.out.println("b (10) = " + Integer.toBinaryString(b));
        System.out.println("a & b (AND) = " + (a & b) + " (" + Integer.toBinaryString(a & b) + ")");
        System.out.println("a | b (OR)  = " + (a | b) + " (" + Integer.toBinaryString(a | b) + ")");
        System.out.println("a ^ b (XOR) = " + (a ^ b) + " (" + Integer.toBinaryString(a ^ b) + ")");
        System.out.println("~a (NOT)    = " + (~a) + " (" + Integer.toBinaryString(~a) + ")");
        // Комментарий: Побитовые операции вычисляются над каждым битом отдельно.
        // Инверсия '~' также меняет знаковый бит, превращая положительное число в отрицательное.
    }

    private void testShifts() {
        System.out.println("\n--- 2. Left and Right Bit Shifts ---");
        int num = 8;
        System.out.println("8 << 1 (8 * 2) = " + (num << 1));
        System.out.println("8 >> 1 (8 / 2) = " + (num >> 1));

        int negNum = -16;
        System.out.println("-16 >> 1 = " + (negNum >> 1));
        // Комментарий: Сдвиг влево '<<' на 1 бит эквивалентен умножению на 2.
        // Арифметический сдвиг вправо '>>' сохраняет знаковый бит.
    }

    private void testUnsignedShift() {
        System.out.println("\n--- 3. Unsigned Right Shift (>>>) ---");
        int negNum = -16;
        System.out.println("Negative (-16) in binary: " + Integer.toBinaryString(negNum));
        System.out.println("-16 >> 2  (signed)   = " + (negNum >> 2));
        System.out.println("-16 >>> 2 (unsigned) = " + (negNum >>> 2));
        // Комментарий: Беззнаковый сдвиг '>>>' заполняет старшие биты нулями,
        // из-за чего отрицательное число превращается в огромное положительное.
    }

    private void testSwapWithoutTemp() {
        System.out.println("\n--- 4. Swap Variables using XOR ---");
        int x = 5;
        int y = 9;
        System.out.println("Before swap: x = " + x + ", y = " + y);

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println("After swap:  x = " + x + ", y = " + y);
        // Комментарий: Обмен значений переменных через XOR работает за счет свойства
        // самообратимости XOR: (A ^ B) ^ B = A. Это позволяет обменивать числа без временной переменной.
    }
}
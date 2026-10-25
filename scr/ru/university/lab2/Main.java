package ru.university.lab2;

import ru.university.lab2.numbers.Task01IntegerTraps;
import ru.university.lab2.numbers.Task02RealArithmetic;
import ru.university.lab2.numbers.Task03Bitwise;

/**
 * Главный класс приложения для запуска всех заданий лабораторной работы № 1.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 1 (для меня — № 2)     ");
        System.out.println("   Студент: Буров Егор | Группа: КБ-251         ");
        System.out.println("================================================\n");

        System.out.println("[1/3] Запуск Задания № 1 (Целочисленные ловушки):");
        new Task01IntegerTraps().run();

        System.out.println("\n------------------------------------------------\n");
        System.out.println("[2/3] Запуск Задания № 2 (Вещественная арифметика):");
        new Task02RealArithmetic().run();

        System.out.println("\n------------------------------------------------\n");
        System.out.println("[3/3] Запуск Задания № 3 (Побитовые операции):");
        new Task03Bitwise().run();

        System.out.println("\n================================================");
        System.out.println("   Все задания успешно выполнены!               ");
        System.out.println("================================================");
    }
}
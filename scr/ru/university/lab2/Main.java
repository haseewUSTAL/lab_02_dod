package ru.university.lab2;

/**
 * Главный класс приложения для сдачи лабораторной работы №2.
 * Запускает интерактивное консольное меню со всеми выполненными заданиями.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Инициализация лабораторной работы (DoD)...");
        Task08Menu menu = new Task08Menu();
        menu.run();
    }
}
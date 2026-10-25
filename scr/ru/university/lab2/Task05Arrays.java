package ru.university.lab2;

import java.util.Arrays;
import java.util.Random;

/**
 * Задание № 5 — Одномерные массивы
 * (Самостоятельная реализация поиска, сортировки и сравнения массивов, без коллекций)
 */
public class Task05Arrays {

    public void run() {
        System.out.println("--- 1. Random Array Generation ---");
        int n = 10;
        int[] arr = generateRandomArray(n, 1, 100);
        printArray("Original array: ", arr);

        System.out.println("\n--- 2. Manual Min, Max, Average ---");
        findMinMaxAverage(arr);

        System.out.println("\n--- 3. Manual Sorting (Bubble Sort) ---");
        printArray("Before sort: ", arr);
        bubbleSort(arr);
        printArray("After sort:  ", arr);

        System.out.println("\n--- 4. Array Comparison Methods ---");
        compareArraysDemo();
    }

    // 1. Заполнение массива случайными числами
    public int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    // Вспомогательный метод для красивого вывода массива
    private void printArray(String label, int[] array) {
        System.out.print(label + "[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 2. Ручной поиск минимума, максимума и среднего арифметического (без Arrays)
    public void findMinMaxAverage(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int min = array[0];
        int max = array[0];
        long sum = 0; // используем long для защиты от переполнения суммы

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
            sum += array[i];
        }

        double average = (double) sum / array.length;

        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
        System.out.println("Average: " + average);
    }

    /**
     * 3. Ручной алгоритм сортировки: Пузырьковая сортировка (Bubble Sort).
     * Выбран этот алгоритм из-за простоты реализации: на каждом шаге
     * соседние элементы сравниваются, и если порядок нарушен, они меняются местами.
     */
    public void bubbleSort(int[] array) {
        if (array == null) return;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Оптимизация: если за проход не было замен, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    // 4. Демонстрация разницы между ==, .equals() и Arrays.equals()
    public void compareArraysDemo() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1;

        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3 ссылается туда же, куда arr1");

        // 1. Оператор == сравнивает ссылки в памяти (указывают ли переменные на один и тот же объект)
        System.out.println("arr1 == arr2 (сравнение ссылок): " + (arr1 == arr2)); // false, разные объекты
        System.out.println("arr1 == arr3 (сравнение ссылок): " + (arr1 == arr3)); // true, одна ссылка

        // 2. Метод .equals() у массивов работает точно так же, как == (не переопределен для содержимого)
        System.out.println("arr1.equals(arr2): " + arr1.equals(arr2)); // false

        // 3. Arrays.equals() корректно сравнивает содержимое массивов поэлементно
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2)); // true
    }
}
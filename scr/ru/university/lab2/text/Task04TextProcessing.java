package ru.university.lab2.text;

/**
 * Задание № 4 — Обработка текста (без использования коллекций)
 */
public class Task04TextProcessing {

    public void run() {
        testPalindrome();
        testReverseWords();
        testAnalyzeText();
        testCaesarCipher();
        testLongestWord();
    }

    private void testPalindrome() {
        System.out.println("--- 1. Palindrome Check ---");
        String s1 = "А роза упала на лапу Азора";
        String s2 = "Hello, World!";
        System.out.println("\"" + s1 + "\" is palindrome? " + isPalindrome(s1));
        System.out.println("\"" + s2 + "\" is palindrome? " + isPalindrome(s2));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void testReverseWords() {
        System.out.println("\n--- 2. Reverse Word Order ---");
        String sentence = "кот съел мышь";
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reverseWords(sentence));
    }

    public String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;
        String[] words = sentence.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private void testAnalyzeText() {
        System.out.println("\n--- 3. Single Pass Text Analysis ---");
        String text = "Java 2026: Hello World!";
        analyzeText(text);
    }

    public void analyzeText(String text) {
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        String lower = text.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c == ' ' || c == '\t' || c == '\n') {
                spaces++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                        c == 'а' || c == 'е' || c == 'ё' || c == 'и' || c == 'о' || c == 'у' || c == 'ы' || c == 'э' || c == 'ю' || c == 'я') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants + ", Digits: " + digits + ", Spaces: " + spaces);
    }

    private void testCaesarCipher() {
        System.out.println("\n--- 4. Caesar Cipher ---");
        String message = "Hello Java";
        int shift = 3;
        String encrypted = caesarCipher(message, shift, true);
        String decrypted = caesarCipher(encrypted, shift, false);
        System.out.println("Original: " + message);
        System.out.println("Encrypted (+3): " + encrypted);
        System.out.println("Decrypted (-3): " + decrypted);
    }

    public String caesarCipher(String text, int shift, boolean encrypt) {
        if (!encrypt) {
            shift = 26 - (shift % 26);
        }
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ('a' + (c - 'a' + shift) % 26);
            } else if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) ('A' + (c - 'A' + shift) % 26);
            }
        }
        return new String(chars);
    }

    private void testLongestWord() {
        System.out.println("\n--- 5. Longest Word Search ---");
        String text = "Программирование на языке Java увлекательно";
        System.out.println("Text: " + text);
        System.out.println("Longest word: " + findLongestWord(text));
    }

    public String findLongestWord(String text) {
        if (text == null || text.isEmpty()) return "";
        String[] words = text.split("\\s+");
        String longest = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        return longest;
    }
}
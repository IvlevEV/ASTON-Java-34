package org.example;

import java.util.Arrays;

import static org.example.Palindrome.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Инициализируем массив уникальных значений
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47, 12, 10, 15};
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};

        // Дан массив, заполненный уникальными значениями типа int.
        // Необходимо найти элемент, который меньше максимума, но больше всех остальных.

        System.out.println("Второй максимум массива целых чисел : " + findSecondMax(arr));

        // Определить, что строка является палиндромом

        System.out.println("Эта строка палендром : " + Palindrome.isPalindrome ("abc"));    // abc - false
        System.out.println("Эта строка палендром : " + Palindrome.isPalindrome ("112233")); // 112233 - false
        System.out.println("Эта строка палендром : " + Palindrome.isPalindrome ("aba"));    // aba - true
        System.out.println("Эта строка палендром : " + Palindrome.isPalindrome ("112211")); // 112211 - true
        System.out.println("Эта строка палендром : " + Palindrome.isPalindrome ("abcc"));   // abcс - false
        System.out.println("Эта строка в опбратонм порядке : " + TurnString.turnString("I love Java"));  //Перевернуть строку и вывести на консоль
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(GetDistinct.getDistinctNumbers(ints))); // Удалить дубликаты из массива и вывести в консоль
        System.out.println("Длина последнего слова : " + LengthOfLastWord.lengthOfLastWord("Hello world"));
        System.out.println("Длина последнего слова : " + LengthOfLastWord.lengthOfLastWord("    fly me    to the moon    ")); // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    }



    public static int findSecondMax(int[] arr) {

        int max = Integer.MIN_VALUE; // Максимальное значение, начинаем с минимального числа
        int secondMax = Integer.MIN_VALUE; // Второе максимальное значение


        for (int num : arr) {

            if (num > max) {
                // Если текущий элемент больше максимума
               secondMax = max; // Сохраняем старое значение максимума как второй максимум
                max = num; // Обновляем максимум на текущий элемент
            }
            // Если текущий элемент меньше максимума, но больше второго максимума
            // Обновляем второй максимум
            else if (num > secondMax) {
                secondMax = num;
            }
        }

        return secondMax;
    }
}


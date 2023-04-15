package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**@author Novikov_Vladislav
         * @version 1.1 */

        Task1();

        Task2();

        Task3();

        Task4();

        Task5();

    }
    /**Функция задания 1
     * Программа, в которой перебираются числа от 1 до 500 и выводятся на экран. Если
     * число делится на 5, то вместо него выводится слово fizz, если на 7, то buzz. Если число
     * делится на 5 и на 7, то выводить слово fizzbuzz. Примечание*: остаток от деления в Java
     * обозначается через символ %.
     */
    private static void Task1() {

        System.out.println("Задание 1");
        for (int i = 0; i < 500; i++)
        {
            if(i%5 == 0)
            {
                System.out.print("fizz");
            }
            if(i%7 == 0)
            {
                System.out.print("buzz");
            }
            if(i%5 !=0 && i%7!=0)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /** Функция задания 2
     * 2 Программа, в которой все переданные во входную строку аргументы выводятся
     * на экран в обратной порядке. Например, если было передано 2 аргумента – make install, то
     * на экран должно вывестись llatsni ekam. Примечание*: для разбора слова по буквам
     * необходимо использовать функцию charAt(). Например, str.charAt(i) вернет символ с
     * позиции i в слове, записанном в строковую переменную str. Команда str.length() возвращает
     * длину слова str.*/
    private static void Task2() {


        System.out.println("Задание 2");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку ");

        String str =  scan.nextLine();
        System.out.println("Результат:");
        for(int i=str.length()-1; i>=0; i--)//Цикл от последнего символа строки до первого
        {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
    /**Функция задания 3
     * 3 Создайте программу, вычисляющую числа Фибоначчи. Числа Фибоначчи –
     * последовательность чисел, в котором каждое следующее число равно сумме двух
     * предыдущих. Начало этой последовательности – числа 1, 1, 2, 3, 5, 8, 13…
     */
    private static void Task3() {
        System.out.println("Задание 3");
        ArrayList<Integer> Fib = new ArrayList<>();
        Fib.add(1);
        Fib.add(1);
        for(int i =0; i < 10; i++) { //Расчёт чисел Фибоначчи
            System.out.println("Число");
            Fib.add(Fib.get(0)+Fib.get(1));
            System.out.println(Fib.get(2));
            Fib.remove(0);
        }
    }
    /**Функция задания 4
     * Создайте программу, вычисляющую факториал целого числа.
     */
    private static void Task4() {
        System.out.println("Задание 4");
        Scanner scan = new Scanner(System.in);
        int fact = 1;
        System.out.println("Введите число");
        int num = scan.nextInt();
        for(int i = 1; i < num;i++) {
            fact *= i;
        }
        System.out.println("Факториал равен ");
        System.out.println(fact);
    }
    /**Функция задания 5
     *Вариант 8. Ввести с консоли 3 целых числа. На консоль вывести: Простые числа. */
    private static void Task5() {
        System.out.println("Задание 5");
        Scanner scr = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();//коллекция чисел

        for(int i = 0; i < 3; i++) {//Заполнение коллеции
            System.out.println("Введите " + (i+1)+"-е число");
            arr.add(scr.nextInt());
        }

        System.out.println("Простые числа:\n");
        for(int i = 0; i < 3; i++) {//Проверка на простые числа
            boolean simple = true;
            for(int j = 2; j < arr.get(i);j++){
                if (arr.get(i)%j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple){
                System.out.println(arr.get(i));
            }
        }
    }
}
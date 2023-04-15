import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.logging.log4j.*;

/**@author Vlad @version 1.1*/
public class Main {
        private static Logger logger = LogManager.getLogger(Main.class.getName());
        public static void main(String[] args) throws FileNotFoundException {

            Scanner scanner;
            byte resMenu = Menu();
            if( resMenu == 1)
            {
                scanner = new Scanner(System.in);
            }
            else
            {
               try {
                   File F1 = new File("Dan.txt");
                   scanner = new Scanner(F1);
               } catch(Exception e)
               {
                   logger.fatal(e);
                   throw new RuntimeException();
               }

            }

            Task1(scanner,resMenu);
            Task2(scanner,resMenu);
            Task3(scanner,resMenu);
            Task4(scanner,resMenu);
            Task5(scanner,resMenu);
            Task6(scanner,resMenu);
            Task7(scanner,resMenu);
            Task8(scanner,resMenu);
        }

        /**
         * Вычислить значения выражения по формуле:
         * @param a - сканер с который считывает данные
         * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/

        private static void Task1(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 1");
            double x, res;
            System.out.println("Здадание 1");
            if(resMenu == 1)
            {
                System.out.println("Введите х: ");
            }
             x = a.nextDouble();
            res = (float) (Math.log(Math.abs(Math.cos(x)))/(Math.log(1+Math.pow(x,2))));
            System.out.println(res);
        }

        /**Дана длина ребра куба. Найти площадь грани, площадь полной поверхности и объем этого куба.
         * @param a - сканер с который считывает данные
         * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task2(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 2");
            float rebro;

            System.out.println("Здадание 2");

            if(resMenu == 1)
            {
                System.out.println("Введите длину ребра: ");
            }
            try {
                rebro = a.nextFloat();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }

            System.out.println("Объём куба = " + Math.pow(rebro, 3));
            System.out.println("Площадь грани = " + Math.pow(rebro, 2));
            System.out.println("Площадь полной поверхности = " + (6 * Math.pow(rebro, 2)));
        }

     /** Определить, равен ли квадрат заданного трехзначного числа кубу суммы цифр этого числа.
     * @param a - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static   void Task3(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 3");
            int s,res1, res2;

            System.out.println("Здадание 3");
            if(resMenu == 1)
            {
                System.out.println("Введите трёхзначное число: ");
            }

            try {
                s = a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }
            res1 = (int) Math.pow(s,2);
            res2 = (int) (s/100 + s%10 + (s/10)%10);
            if (res1 == res2)
            {
                System.out.println("Первое число = второму");
            }
            else
            {
                System.out.println("Числа не равны");
            }
        }
    /** Заданы размеры А, В прямоугольного отверстия и размеры X, Y, Z кирпича. Определить, пройдет ли кирпич через отверстие.
     * @param scan - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task4(Scanner scan, byte resMenu)
        {   logger.debug("Вызвался метод задания 4");
            ArrayList <Integer> mas1 = new ArrayList<>();
            ArrayList <Integer> mas2 = new ArrayList<>();
            int a,b,x,y,z;
            int max1 = 0, mini = 0, min2 = 0;
            System.out.println("Задание 4");
            if(resMenu == 1)
            {
                System.out.println("Введите размеры отверстия (А, В): ");
            }
            try {
                a = scan.nextInt();
                b = scan.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }

            if(resMenu==1)
            {
                System.out.println("Введите размеры кирпича (X, Y, Z): ");
            }
            try
            {
                x = scan.nextInt();
                y = scan.nextInt();
                z = scan.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }
            mas1.add(a);
            mas1.add(b);
            mas2.add(x);
            mas2.add(y);
            mas2.add(z);

            for (int i=0; i < mas2.size(); i++){
                if (mas1.get(0) > mas2.get(i)){
                    if (mas2.get(i) > max1){
                        max1 = mas2.get(i);
                        mini = i;
                    }
                }
            }
            if (max1==0) {
                System.out.println("Кирпич не влезет");
            }
            else {
                mas2.remove(mini);
                min2 = Collections.min(mas2);
                if (min2<=mas1.get(0)) {
                    System.out.println("Кирпич пролез");
                }
                else
                    System.out.println("Кирпич не влезет");
            }
        }

    /**Написать программу, которая по номеру месяца выдает название следующего за ним месяца (при m = 1 получаем февраль, 4 — май). (switch)
     * @param a - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task5(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 5");
            int nomer = 0;
            System.out.println("Задание 5");
            System.out.println("Введите номер месяца (1-12): ");
            try {
                nomer = a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
              throw new RuntimeException();
            }
            nomer++;
            switch (nomer)
            {
                case 1: case 13: System.out.println("Январь"); break;
                case 2: System.out.println("Февраль"); break;
                case 3: System.out.println("Март"); break;
                case 4: System.out.println("Апрель"); break;
                case 5: System.out.println("Май"); break;
                case 6: System.out.println("Июнь"); break;
                case 7: System.out.println("Июль"); break;
                case 8: System.out.println("Август"); break;
                case 9: System.out.println("Сентябрь"); break;
                case 10: System.out.println("Октябрь"); break;
                case 11: System.out.println("Ноябрь"); break;
                case 12: System.out.println("Декабрь"); break;
                default: System.out.println("Такого месяца нет");
            }
        }

    /**Среди всех n-значных чисел указать те, сумма цифр которых равна данному числу k.
     * @param a - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task6(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 6");
            int kol,k;
            ArrayList <Integer> mas3 = new ArrayList<>();

            System.out.println("Задание 6");
            if(resMenu == 1)
            {
                System.out.println("Введите кол-во чисел: ");
            }
            try
            {
                kol = a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }

            for (int i=0; i<kol; i++)
            {
                if(resMenu == 1)
                {
                    System.out.println("Введите " + (i+1) + " число: ");
                }
                mas3.add(a.nextInt());
            }

            System.out.println("Введите число для сравнения: ");
            try
            {
                k = a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }

            for (int i=0; i<kol; i++)
            {
                int resDel = 1;
                int sum = 0;
                for (int j=0; resDel>0; j++)
                {
                    sum+=(mas3.get(i) / Math.pow (10,j) %10);
                    resDel = (int) (mas3.get(i) / Math.pow (10, j));
                }
                if (sum==k)
                {
                    System.out.println(mas3.get(i));
                }
            }
        }

    /**Дано натуральное число n. Вычислить значение по формуле p = (1 - 1/2) * (1 -1/4)*(1-1/6)...(1-1/2n)
     * @param a - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task7(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 7");
            int n;
            double P;
            System.out.println("Задание 7");
            if(resMenu == 1)
            {
                System.out.println("Введите натуральное число: ");
            }
            try
            {
                n = a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }
            P = (1 - (1.0/2));
            for (int i=4; i<=n*2; i+=2)
            {
                P*= (1 - (1.0/i));
            }
            System.out.println("Результат вычисления: " + P);
        }

        /**Найти сумму n членов геометрической прогрессии 3, 6, 18, … Число членов вводится с клавиатуры.
     * @param a - сканер с который считывает данные
     * @param  resMenu - результат выполнения функции Menu(), задающий параметры отображения сообщений*/
        private static void Task8(Scanner a, byte resMenu)
        {
            logger.debug("Вызвался метод задания 8");
            int znamGeo = 2, tGeo = 3, sumGeo = 3, kolGeo;

            System.out.println("Задание 8");
            if (resMenu== 1)
            {
                System.out.println("Введите число членов геометрической прогресии: ");
            }
            try {
                kolGeo= a.nextInt();
            }
            catch (Exception e)
            {
                logger.fatal(e);
                throw new RuntimeException();
            }


            for (int i = 1; i < kolGeo; i++)
            {
                sumGeo+= tGeo*znamGeo;
                tGeo *=znamGeo;
            }

            System.out.println(sumGeo);
        }

        private static byte Menu()
        {
            Scanner scan = new Scanner(System.in);
            byte res = 0;
            final byte consolWork = 1;
            final byte fileWork = 2;
            while(res !=consolWork && res != fileWork)
            {
                System.out.println("Ввыедите код операции");
                System.out.println("1 - работа с консолью");
                System.out.println("2 - работа с файлом");

                res = scan.nextByte();
            }
            return res;
        }

}
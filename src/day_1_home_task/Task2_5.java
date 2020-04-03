package day_1_home_task;

import java.util.Scanner;

public class Task2_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = scanner.nextInt();
        int[] mas = new int[size];
        int b = 10;
        int shift = 0;

        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * b);
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        while (shift < 2) {
            int last = mas[mas.length - 1];
            for (int i = mas.length - 2; i >= 0; i--) {
                mas[i + 1] = mas[i];
            }
            mas[0] = last;
            shift++;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print( mas[i] + " ");
        }
    }
}

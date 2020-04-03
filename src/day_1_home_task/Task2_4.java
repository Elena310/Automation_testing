package day_1_home_task;

import java.util.Scanner;

public class Task2_4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = scanner.nextInt();
        int[] mas = new int[size];
        int b = 10;
        int temp;

        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * b);
            System.out.print(mas[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < mas.length - 1; i = i + 2) {
            temp = mas[i];
            mas[i] = mas[i + 1];
            mas[i + 1] = temp;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }

    }
}
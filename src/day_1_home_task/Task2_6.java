package day_1_home_task;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = scanner.nextInt();
        System.out.println("Fill the array");
        int[] mas = new int[size];

        for (int i = 0; i < size; i++) {
            mas[i] = scanner.nextInt();
        }

        Arrays.stream(mas).boxed().filter(i -> i % 2 == 0 && i > 10 && i <= 20).sorted().collect(Collectors.toList()).
                forEach(i -> System.out. print(i + " "));
    }
}

package day_1_home_task;

public class Task2_1 {
    public static void main(String[] args) {
        int i;
        int j = 5;
        i = ++j;
        System.out.println("i = " + i + " " +  "j =  " + j);
        System.out.println();

        int x;
        int y = 5;
        x = y++;
        System.out.println("x = " + x + " " +  "y =  " + y);

        /*  В примере показано 2 вида инкремента (декремент и постинкремент). Разница в очередности операций. В первом
        случае переменная j сначала увеличилась на 1, а потом переменной i мы присвоили j.
           Во втором случае, переменной x мы сначало присвоили переменную y, а потом увеличили переменную y на 1.
         */
    }
}

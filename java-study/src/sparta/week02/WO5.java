package sparta.week02;

public class WO5 {

    public static void main(String[] args) {
        int number = 10;

        // 기본 대입 연산자

        number = number + 2;
        System.out.println("number = " + number); // 12

        number = number -2;
        System.out.println("number = " + number); // 10

        number = number * 2;
        System.out.println(number); // 20;

        number = number / 2;
        System.out.println("number = " + number); // 10;

        number = number % 2;
        System.out.println("number = " + number); // 0;

        System.out.println("=====================================");

        // 복합 대입 연산자

        number = 10;

        number += 2;
        System.out.println("number = " + number); // 12

        number -= 2;
        System.out.println("number = " + number); // 10

        number *=2;
        System.out.println("number = " + number); // 20

        number /=2;
        System.out.println("number = " + number); // 10

        number %=2;
        System.out.println("number = " + number); // 0

        // ++ , --

        number++;
        System.out.println("number = " + number); // 1

        //number = number + 1;

        number--;
        System.out.println("number = " + number); //0
    }
}

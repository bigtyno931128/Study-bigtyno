package fastcampus;

public class MinMaxProblem {
    public static void main(String[] args) {

        int[] numbers = { 10 , 55 , 23 , 2 , 79 , 101 , 16 , 82 ,30 , 45};

        int min = numbers[0];
        int max = numbers[0];
        int minPos = 0;
        int maxPos = 0;

        for (int i = 1; i < numbers.length; i++) {

            if (min > numbers[i]) {
                min = numbers[i];
                minPos = i + 1;
            }

            if (max < numbers[i]) {
                maxPos = numbers[i];
                maxPos = i + 1;
            }

        }

    }
}

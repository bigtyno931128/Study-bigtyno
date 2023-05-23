package hackkerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mini_Max_Sum {

    public static void main(String[] args) throws IOException {
        /*
        무조건 5 개이기 때문에 최솟값은 앞에 4 자리고  최댓값은 뒤에 4자리 일 것이다 ㅇㅈ?
         */
        BufferedReader bc = new BufferedReader(new InputStreamReader(System.in));
        String n = bc.readLine();
        String[] StringN = n.split(" ");
        int[] arr = new int[StringN.length];

        for (int i = 0; i<StringN.length; i++) {
            arr[i]= Integer.parseInt(StringN[i]);
        }

        Arrays.sort(arr);

        int min = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
            max = sum - arr[0];
            min = sum - arr[arr.length-1];
        }

        System.out.printf("%d %d", min , max);
    }
}

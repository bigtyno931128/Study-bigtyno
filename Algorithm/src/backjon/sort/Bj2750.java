package backjon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 수 정렬 하기
public class Bj2750 {


    // n 개 의 수를 오름차순 정렬 .
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]  = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int answer : arr) {
            System.out.println(answer);
        }
     }

}

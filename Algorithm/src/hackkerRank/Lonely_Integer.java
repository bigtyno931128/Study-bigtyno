package hackkerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lonely_Integer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] StringArr = br.readLine().split(" ");

        int[] arr = new int[StringArr.length];

        for (int i = 0; i<StringArr.length; i++) {
            arr[i] = Integer.parseInt(StringArr[i]);
        }

        Arrays.sort(arr);

        int result = arr[0];

        for (int i = 1; i<arr.length; i++){
            if(result == arr[i]) {
                result = arr[i];
            } else {
                result = arr[i];
                if (result != arr[i]) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

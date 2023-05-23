package hackkerRank;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class PlusMinus {

    /*
    처음 작성했던 코드는 시간 초과가 발생하였는데 이를 개선하기 위해 sort 한 후 계산
    sorting 할 경우 음수 부터 arr[] = [ 음수 , 0 , 양수 ] 순이 될 것 이고 음수부터 증가시키고 0까지 증가 시키면 나머지는 양수이기에 최대길이에서 현재 i 번째 값을 빼주면
    양수인 원소만 남게댐
     */

//    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String[] numbersString = input.split(" ");
//        int[] numbers = new int[numbersString.length];
//
//        for (int i = 0; i < numbersString.length; i++) {
//            numbers[i] = Integer.parseInt(numbersString[i]);
//        }
//
//        int a = 0;
//        int b = 0;
//        int c = 0;
//
//        for (int i= 0; i < numbers.length; i++) {
//            if (numbers[i] > 0) {
//                a += 1;
//            } else if (numbers[i] == 0) {
//                b += 1;
//            } else {
//                c += 1;
//            }
//        }
//
//        System.out.printf("%.6f%n",(double) a/numbers.length );
//        System.out.printf("%.6f%n",(double) b/numbers.length);
//        System.out.printf("%.6f%n",(double) c/numbers.length);
//
//
//    }
public static void plusMinus(List<Integer> arr) {
    // Write your code here
    int len = arr.size();
    float positive = 0;
    float negative = 0;
    float zero = 0;

    Collections.sort(arr);

    for(int i = 0; i<len; i++){
        if(arr.get(i) < 0) {
            negative++;
        }else if(arr.get(i)==0){
            zero++;
        }else {
            positive = len-i;

        }
    }
    System.out.printf("%.6f%n", positive/len);
    System.out.printf("%.6f%n", negative/len);
    System.out.printf("%.6f%n", zero/len);
}

}


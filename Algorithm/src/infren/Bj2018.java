package infren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 투 포인터 https://www.acmicpc.net/problem/2018
public class Bj2018 {

    /*
      문제 : 자연수 N 은 몇 개의 연속된 자연수의 합
      입력 : 첫 줄에 정수 N
      출력 : 입력된 자연수 N 을 몇 개의 연속된 자연수의 합
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.valueOf(br.readLine());

        int start = 0;
        int sum = 0;
        int result = 0;

        for (int i = start; i < N; i++) {

            if(sum < N ) {
                sum += i;
            } else if (sum == N) {
                result += 1;

            } else {
                start = i;
            }
        }

        System.out.println(result);
    }

    /*
        풀이 : 주어진 입력 값 N 의 최댓값이 10,000,000 으로 매우 크게 잡혀 있다 . 이런상황에서는 O ( nlogn) 의 시간 복잡도 알고리즘을 사용하면 제한시간을 초과하므로 O(n)
        시간 복잡도 알고리즘 을 사용해야 하며 이럴때 자주 사용하는 방법이 투포인터 이다 .
     */
}

package backjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 -     설탕 배달
public class Bj2839 {
    // 설탕은 3kg 와 5 kg 이 있다 .  ( 최대한 적은봉지로 배달 )
    // 먼저 5로 나눌수 있다면 5로 나누면서  +
    // 없다면 3 으로 나누면서 +
    // 둘다 안돼면 -1
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) {
            System.out.println(-1);

        } else if (N % 5 == 0) {

            System.out.println(N / 5);

        } else if (N % 5 == 1 || N % 5 == 3) {

            System.out.println((N / 5) + 1);

        } else if (N % 5 == 2 || N % 5 == 4) {

            System.out.println((N / 5) + 2);
        }
    }
}
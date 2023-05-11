package backjon;

import org.omg.Messaging.SyncScopeHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 베르트랑 공준
public class Bj4948 {

    // 입력의 마지막에는 0
    // 소수의 갯수 구하기 .

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            int cnt = 0 ;
            if (n == 0 ) break;

            boolean[] arr = new boolean[(2 * n) + 1];

            arr[0] = arr[1] = true;

            for(int i = 2; i * i <= 2 * n; i++) {
                if(!arr[i]) {
                    for(int j = i * i; j <= 2 * n; j += i) {
                        arr[j] = true;
                    }
                }
            }
            for(int i = n + 1; i <= 2 * n; i++) {
                if(!arr[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }

}

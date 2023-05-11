package backjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 그룹 단어 체커
public class Bj1316 {
    static int N;
    static String str;
    static boolean[] check;
    static ArrayList<Character> al;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = N;
        for (int i = 0; i < N; i++) {
            str = br.readLine();

            if(!check()) {
                result--;
            }
        }
        System.out.println(result);
    }
    private static boolean check() {
        check = new boolean[26];
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);
            if(now != prev) {
                if(check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                }else {
                    return false;
                }
            }else {
                continue;
            }
        }
        return true;
    }
}

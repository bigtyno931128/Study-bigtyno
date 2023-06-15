package sparta.week02;

public class Arr01 {

    // 복사
    public static void main(String[] args) {



        // 얕은 복사
        int[] a = {1, 2, 3 ,4 };
        int[] b = a; // 얕은 복사

        b[0] = 3; // b 배열의 0번째 순번값을 3으로 수정 했습니다. ( 1 -> 3 )

        System.out.println(a[0]); // 출력하면 결과가 3 <- a 배열의 0번째 순번값도 3으로 조회된다 .

        // 깊은 복사 (for , clone ()

        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        b[0] = 4; // b 배열의  0 번째 순번값을 4으로 수정했다 . ( 1-> 4)

        System.out.println(a[0]); // 출력
    }
}

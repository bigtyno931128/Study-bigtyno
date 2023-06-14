package week02;

public class WO6 {

    public static void main(String[] args) {

        // 대입 연산자에서 주의해야 할 점
        int a = 10;
        int b = 10;
        int val = ++a + b--; // 11 + 10 = 21

        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 9
        System.out.println("val = " + val); // 21  why 21 ? 뒤에 연산자가 있을 경우는 연산이 끝나고 추가
    }
}

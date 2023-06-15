package sparta.week02;

public class WO4 {

    // 논리 연산자
    // 비교 연산의 결과값으로 받을 수 있는 bollean 값을 연결하는 연산자
    // 조건을 연결 하였을 때 boolean 값들을 조합하여 true or false 출력

    public static void main(String[] args) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = false;

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        System.out.println(flag1 || flag2);
        System.out.println(flag1 || flag2 || flag3);
        System.out.println(flag1 && flag2);
        System.out.println(flag2 && flag3);
    }
}

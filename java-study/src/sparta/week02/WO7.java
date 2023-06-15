package sparta.week02;

public class WO7 {

    public static void main(String[] args) {

        // 삼항 연사자
        // 비교 연산자와 항상 함께 쓰인다.
        // 비교 연산자의 결과 : true or false -> 이 겨ㅓㄹ과의 값에 따라 결정되는 무언가
        // 조건 ? 참 : 거짓

        int x = 1;
        int y = 9;

        boolean b = (x==y) ? true : false;
        System.out.println("b = " + b);

        String s = (x != y) ? "정답" : "오답";
        System.out.println("s = " + s);

        // instance of
        // 피 연산자와 조건에 명시된 클래스의 객체인지 비교화여 맞으면 - > true  , 틀리면 -> false

    }
}

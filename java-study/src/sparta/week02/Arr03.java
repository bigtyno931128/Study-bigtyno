package sparta.week02;

public class Arr03 {
    // 기본형 변수는 값 전체를 저장하지만 , 참조형 변수의 경우 별도의 공간에 값을 저장 후 그 주소를 저장한다 .

    public static void main(String[] args) {
        String str = "ABCD";

        int strLength = str.length();

        System.out.println(strLength);

        char strChar = str.charAt(1);
        System.out.println(strChar);
    }

}

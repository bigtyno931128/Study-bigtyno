package sparta.week04.sample1;

// 예외 클래스를 만들어서 예외를 정의
public class OurBadException extends Exception {

    public OurBadException () {
        super("위험한 행동을 하면 예외 처리를 해줘야함 ");
    }

}

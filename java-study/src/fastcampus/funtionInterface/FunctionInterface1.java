package fastcampus.funtionInterface;

public class FunctionInterface1 {

    public static void main(String[] args) {
        // 인터페이스를 내부 익명 내부 클래스로 구현
        MathOperation mo = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return 0;
            }
        };
        int result = mo.operation(10, 20);
        System.out.println(result);
    }
}

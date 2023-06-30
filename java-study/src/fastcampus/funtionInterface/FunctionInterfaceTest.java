package fastcampus.funtionInterface;

public class FunctionInterfaceTest implements MathOperation {

    public static void main(String[] args) {
        MathOperation mathOperation = new FunctionInterfaceTest();
        int operation = mathOperation.operation(10, 20);
        System.out.println(operation);
    }
    @Override
    public int operation(int x, int y) {
        return x+y;
    }
}

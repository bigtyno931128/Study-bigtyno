package sparta.week04.gen;

// 1. 제네릭은 클래스 or 메서드에 사용 가능하다 .
// 2. <> 안에 들어가야 할 타입을 명시 
public class Generic<T> {
    // 2. 내부 필드에 Type 이 정의가 됨 
    private T t;
    // 3. 메서드의 타입 또한 마찬가지 return 타입
    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        // 4.
        Generic<String> stringGeneric = new Generic<>();
        // 5.
        stringGeneric.set(("Hello World"));

        String tValueTurnOutWithString = stringGeneric.get();

        System.out.println(tValueTurnOutWithString);
    }
}

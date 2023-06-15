package sparta.week02.collection;

import java.util.Stack;

public class Col3 {

    public static void main(String[] args) {
        //Stack 
        // 수직으로 값을 쌓아놓고 , 넣었다가 뺸다 . FIFO
        // push, peek , pop 
        // 최근 저장된 데이터를 나열하고ㅓ 싶거나 , 데이터 중복 처리를 막고 싶을 때 사용

        Stack<Integer> integerStack = new Stack<Integer>(); 
        
        integerStack.push(10);
        integerStack.push(15);
        integerStack.push(1);
        
        while (!integerStack.isEmpty()) {
            System.out.println("integerStack.pop() = " + integerStack.pop());
        }

        integerStack.push(10);
        integerStack.push(15);
        integerStack.push(1);

        System.out.println("integerStack.peek() = " + integerStack.peek());
    }

}

package sparta.week02;

public class Arr08 {

    public static void main(String[] args) {
        // 최대값 구하기
        int[] arr = {3,2,1,5,1};

        // 최대값 초기화 세팅
        int max = 0;

//        for (int i=0; i < arr.length; i++){
//            if (max < arr[i]) {
//                max = arr[i];
//            }
//        }

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("max = " + max);
    }
}

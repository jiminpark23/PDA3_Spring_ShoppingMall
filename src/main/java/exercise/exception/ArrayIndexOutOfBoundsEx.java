package exercise.exception;

public class ArrayIndexOutOfBoundsEx {
    public static void main(String[] args) {
        // 예외 발생 상황
        // try catch
        // 어떤 Exception 클래스로 예외 받아줄 건지

        int[] numbers = {1, 2, 3, 4};
        int[] numbers2 = {1, 2, 3, 4};

        try {
            System.out.println(numbers[5]);
            System.out.println(numbers2[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 모자라..");
        }
    }

}

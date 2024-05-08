package exercise;

import java.util.ArrayList;

public class ArrayIndexOutOfBoundEx {
    public static void main(String[] args) {
        // 예외 발생 상황
        // try catch
        // 어떤 Exception 클래스로 예외 받아줄 건지


        try {
            int[] numbers = {1, 2, 3, 4};
            System.out.println(numbers[5]);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

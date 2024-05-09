package exercise.exception;

import java.util.Scanner;

public class ArithmeticEx {
    public static void main(String[] args) {
        int result = divide(10, 0); // main은 static = 실행될 때부터 메모리에 올라가있음. divide도 static으로 만들어줘야 쓸 수 있음
    }

    public static int divide(int x, int y) {
        int result = 0;

        try {
            result = x / y;
        } catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        }

        return result;
    }
}

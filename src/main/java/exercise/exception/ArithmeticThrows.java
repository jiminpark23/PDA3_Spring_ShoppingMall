package exercise.exception;

public class ArithmeticThrows {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // main은 static = 실행될 때부터 메모리에 올라가있음. divide도 static으로 만들어줘야 쓸 수 있음

        } catch (ArithmeticException e) {
            System.out.println("내가 대신 처리할게...");
        }
    }


    public static int divide(int x, int y) throws ArithmeticException {
        int result = 0;
        try {
            result = x / y;
        } catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        }

        return result;
    }
}

package exercise.exception;

import com.example.shoppingmall.utils.Validator;

import java.util.Scanner;

public class InputMismatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("점수를 입력하세요: ");
            String input = scanner.nextLine();    // inputMismatchException - nextLine()으로 해결

            if (input.equals("q")) {
                System.out.println("프로그램 종료");
                scanner.close();
                break;
            }

            try {
                if(Validator.isNumber(Integer.parseInt(input))){
                    if(Integer.parseInt(input) >= 60 ) {
                        System.out.println("합격입니다");
                    } else {
                        System.out.println("다음에 다시 봐요");
                    }
                }
            } catch (NumberFormatException e) {
                // 잘못된 문자열을 숫자로 형 변환할 때 발생하는 예외 클래스
                System.out.println("NumberFormatException");
            }
        }
    }
}

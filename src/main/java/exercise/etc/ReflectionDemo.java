package exercise.etc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 최상위 클래스(타입) Object에 나의 객체를 담아요
        // 내 객체의 메소드 쓸 수 있어요?
        Object newjeans = new Newjeans();
//        newjeans.sing();

//        Class newJeansClass = Newjeans.class;
        // Method : reflection의 class 이름
        Method sing = Newjeans.class.getMethod("sing");
        sing.invoke(newjeans, null);  // invoke() : 실행시켜줘! (두번째 인자: 해당 메소드의 매개변수 담는 곳)
    }
}


class Newjeans {
    public void sing() {
        System.out.println("뉴진스의 하입보이요");
    }
}
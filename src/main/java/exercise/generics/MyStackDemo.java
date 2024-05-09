package exercise.generics;

import java.util.ArrayList;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack<>();
        System.out.println(stackStr.isEmpty());
        stackStr.push("a");
        stackStr.push("b");
        stackStr.push("c");

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());;

        stackStr.printElements();
    }
}


class MyStack<T> {
    ArrayList<T> arrayList = new ArrayList<T>();

    boolean isEmpty() {
        return arrayList.isEmpty();
    }

    void push(T data) {
        arrayList.add(data);
    }

    T pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    T peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    void printElements() {
//        for (int i=0; i<arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
        System.out.println(arrayList);
    }
}
package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        // 3종류의 차가 순서대로 bbang()
//        Car[] cars = new Car[3];
//        cars[0] = new Taxi();
//        cars[1] = new Bus();
//        cars[2] = new ElecCar();
//
//        for (int i=0; i<3; i++) {
//            cars[i].bbang();
//        }
//
//        ArrayList<Car> carArrayList = new ArrayList<>();
//        carArrayList.add(new Taxi());
//        carArrayList.add(new Bus());
//        carArrayList.add(new ElecCar());
//
//        for (int i=0; i<carArrayList.size(); i++) {
//            carArrayList.get(i).bbang();
//        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Taxi());
        carList.add(new Bus());
        carList.add(new ElecCar());
//        carList.print();
        for (int i=0; i<carList.size(); i++) {
            carList.get(i).bbang();
        }
    }
}

class CarList<T> {
//    ArrayList<Car> arrayList = new ArrayList<Car>();
    ArrayList<T> arrayList = new ArrayList<T>();

//    void add(Car car) {
        // arrayList에 car 객체를 하나씩 추가
//        arrayList.add(car);
//    }

    void add (T data) {     // 제네릭 (object로 모든 걸 받음)
        // arrayList에 car 객체를 하나씩 추가
        arrayList.add(data);
    }

//    void print() {
//        // bbang(); for문 돌려서 출력
//        for (int i=0; i<arrayList.size(); i++) {
//            arrayList.get(i).bbang();
//        }
//    }

    int size() {
        return arrayList.size();
    }

    T get(int idx) {
        return arrayList.get(idx);
    }
}

class Car {
    void bbang() {
        System.out.println("경적 소리");
    }
}

class Bus extends Car {
    void bbang() {
        System.out.println("버수우웅~");
    }
}

class Taxi extends Car {
    void bbang() {
        System.out.println("택씨이잉~");
    }
}

class ElecCar extends Car {
    void bbang() {
        System.out.println("빵빵");
    }
}
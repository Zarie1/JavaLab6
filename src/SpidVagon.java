import java.util.ArrayList;
import java.util.List;

public class SpidVagon {
    public static void main(String[] args) {
        MyLinkedList train1 = new MyLinkedList() {};

        MyLinkedList train2 = new MyLinkedList(new PassengerCar(100, 50, 3)) {};

        List<Vagon> vagonList = new ArrayList<>();
        vagonList.add(new PassengerCar(150, 80, 4));
        vagonList.add(new BaggageCar(0, 200, 1));
        MyLinkedList train3 = new MyLinkedList(vagonList) {};


        train1.add(new LuxuryCar(50, 100, 5));
        train2.add(new LuxuryCar(30, 40, 2));
        train3.add(new LuxuryCar(80, 50, 3));

        train2.remove(1);

        System.out.println("Потяг 1:");
        for (Vagon car : train1) {
            car.printDetails();
        }

        System.out.println("\nПотяг 2:");
        for (Vagon car : train2) {
            car.printDetails();
        }

        System.out.println("\nПотяг 3:");
        for (Vagon car : train3) {
            car.printDetails();
        }
    }
}

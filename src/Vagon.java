/**
 * Абстрактний клас, який описує базову інформацію для вагонів потягу.
 * Всі типи вагонів повинні успадковувати цей клас.
 */
abstract class Vagon {
    protected int passengers; // Кількість пасажирів у вагоні
    protected int luggage;    // Кількість багажу у вагоні
    protected int comfortLevel; // Рівень комфортності вагона

    /**
     * Конструктор для створення об'єкта типу Vagon.
     *
     * @param passengers кількість пасажирів у вагоні
     * @param luggage кількість одиниць багажу у вагоні
     * @param comfortLevel рівень комфортності вагона
     */
    public Vagon(int passengers, int luggage, int comfortLevel) {
        this.passengers = passengers;
        this.luggage = luggage;
        this.comfortLevel = comfortLevel;
    }

    /**
     * Метод для отримання кількості пасажирів у вагоні.
     *
     * @return кількість пасажирів
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Метод для отримання кількості багажу в вагоні.
     *
     * @return кількість одиниць багажу
     */
    public int getLuggage() {
        return luggage;
    }

    /**
     * Метод для отримання рівня комфортності вагона.
     *
     * @return рівень комфортності
     */
    public int getComfortLevel() {
        return comfortLevel;
    }

    /**
     * Абстрактний метод для виведення інформації про вагон.
     * Повинен бути реалізований у кожному з нащадків.
     */
    public abstract void printDetails();
}

/**
 * Клас для пасажирського вагона.
 * Наслідує абстрактний клас Vagon та реалізує метод printDetails.
 */
class PassengerCar extends Vagon {

    public PassengerCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    @Override
    public void printDetails() {
        System.out.println("Пасажирський вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}

/**
 * Клас для багажного вагона.
 * Наслідує абстрактний клас Vagon та реалізує метод printDetails.
 */
class BaggageCar extends Vagon {

    public BaggageCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    @Override
    public void printDetails() {
        System.out.println("Багажний вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}

/**
 * Клас для люксового вагона.
 * Наслідує абстрактний клас Vagon та реалізує метод printDetails.
 */
class LuxuryCar extends Vagon {

    public LuxuryCar(int passengers, int luggage, int comfortLevel) {
        super(passengers, luggage, comfortLevel);
    }

    @Override
    public void printDetails() {
        System.out.println("Люксовий вагон: " + passengers + " пасажирів, " + luggage + " одиниць багажу, комфортність: " + comfortLevel);
    }
}
//Observer Pattern

//Use Case: A weather station that notifies different display units (e.g., smartphone app, desktop widget, LED display) when the temperature changes.

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete Observers
class SmartphoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Smartphone Display: Temperature updated to " + temperature + " degrees.");
    }
}

class LEDDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("LED Display: Temperature updated to " + temperature + " degrees.");
    }
}

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

public class BehavioralDesignPattern1 {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer phoneDisplay = new SmartphoneDisplay();
        Observer ledDisplay = new LEDDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(ledDisplay);

        station.setTemperature(25.0f);
    }
}
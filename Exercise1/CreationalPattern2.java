//Factory Pattern

//Use Case: A vehicle factory that creates different types of vehicles (Car, Bike, Truck) based on user input.


// Product interface
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

// Factory
class VehicleFactory {
    public Vehicle createVehicle(String type) {
        switch (type) {
            case "Car":
                return new Car();
            case "Bike":
                return new Bike();
            case "Truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}

public class CreationalPattern2 {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.createVehicle("Car");
        car.drive();

        Vehicle bike = factory.createVehicle("Bike");
        bike.drive();
    }
}
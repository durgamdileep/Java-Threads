package com.dileep.Combining;

import java.util.ArrayList;
import java.util.List;

public class LocalDB {
    private List<Car> cars;

    public LocalDB() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota Camry", "Alice"));
        cars.add(new Car("Honda Civic", "Bob"));
        cars.add(new Car("Tesla Model 3", "Charlie"));
        cars.add(new Car("Ford Mustang", "Diana"));
        cars.add(new Car("BMW 3 Series", "Ethan"));
        cars.add(new Car("Toyota Corolla", "Alice")); // extra for demo
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    // 🔍 Get owner by model name
    public String getOwnedBy(String modelName) {
        for (Car car : cars) {
            if (car.getModelName().equalsIgnoreCase(modelName)) {
                return car.getOwnedBy();
            }
        }
        return null; // or "Not found"
    }

    // 🔍 Get model(s) by owner name
    public List<String> getModelBy(String ownerName) {
        List<String> models = new ArrayList<>();
        for (Car car : cars) {
            if (car.getOwnedBy().equalsIgnoreCase(ownerName)) {
                models.add(car.getModelName());
            }
        }
        return models;
    }
}


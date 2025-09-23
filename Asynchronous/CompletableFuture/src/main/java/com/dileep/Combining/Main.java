package com.dileep.Combining;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        LocalDB db = new LocalDB();

        CompletableFuture<String> person1Name = CompletableFuture.supplyAsync(() -> {
            return db.getOwnedBy("Toyota Camry");
        });
        CompletableFuture<String> person2Name = CompletableFuture.supplyAsync(() -> {
            return db.getOwnedBy("Ford Mustang");
        });


        person2Name.thenCombine(person1Name, (person1, person2) -> {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car(
                    db.getModelBy(person1).get(0)
                    , person1));
            cars.add(new Car(
                    db.getModelBy(person2).get(0)
                    , person2));
            return cars;
        }).thenAccept(cars -> {
            for (Car car : cars) System.out.println(car);
        });

        person1Name.thenAcceptBoth(person2Name,(person1,person2)->{
            System.out.println("Person 1: "+ person1 +"\n"+"Person 2: "+ person2);
        });
    }
}

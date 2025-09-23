package com.dileep.Combining;

public class Car {
    private String modelName;
    private String ownedBy;

    public Car(String modelName, String ownedBy) {
        this.modelName = modelName;
        this.ownedBy = ownedBy;
    }

    public String getModelName() {
        return modelName;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", ownedBy='" + ownedBy + '\'' +
                '}';
    }
}


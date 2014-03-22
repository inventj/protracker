package main.java.be.protracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {

    @Id
    private String licensePlate;

    private Tracker tracker;

    public Vehicle(){
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("licensePlate='").append(licensePlate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

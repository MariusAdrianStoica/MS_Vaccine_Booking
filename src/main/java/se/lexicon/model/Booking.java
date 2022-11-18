package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private final String id;                // if final we have no setters
    private final LocalDateTime dateTime;   // if final we have no setters
    private final double price;             // if final we have no setters
    private final String vaccineType;       // if final we have no setters
    private boolean vacant;
    private Premises premises;
    private Patient patient;

// Constructor


    public Booking(LocalDateTime dateTime, double price, String vaccineType) {
        this.id = UUID.randomUUID().toString();
        // UUID = random number generated automatically.toString()
        this.dateTime = dateTime;
        this.price = price;
        this.vaccineType = vaccineType;
        this.vacant = true;
           }

    //Getters & Setters


    public String getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getPrice() {
        return price;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public boolean isVacant() {
        return vacant;
    }

    // we don't need setter for setVacant


    public Premises getPremises() {
        return premises;
    }

    public void setPremises(Premises premises) {
        this.premises = premises;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        this.vacant= (patient == null);

        /*if (patient == null){
        this.vacant = true;
        }else {
        this.vacant=false;
        } */
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", vaccineType='" + vaccineType + '\'' +
                ", vacant=" + vacant +
                '}';
    }
}

package se.lexicon.model;

import java.time.LocalDate;
import java.util.List;

public class Patient {
    private String ssn;
    private String name;
    private String email;
    private LocalDate birthdate;
    private AppUser appUser;
    //private List<Booking> bookingList;

    //Constructors

    public Patient(String ssn, String name, String email, AppUser appUser) {
        setSsn(ssn);        //this.ssn = ssn;
        setName(name);      //this.name = name;
        this.email = email; // email can be set null directly. In other case:  setEmail(email);
        setAppUser(appUser);//this.appUser = appUser;
    }
    // Getters & Setters


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if (ssn == null) throw new IllegalArgumentException("SSN was null");
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Name was null");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email was null");
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null) throw new IllegalArgumentException("Birthdate was null");
        this.birthdate = birthdate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("AppUser was null");
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}

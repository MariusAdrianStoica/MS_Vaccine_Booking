package se.lexicon.dao;

import se.lexicon.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
    private List<Patient> patientList;

    //Constructor


    public PatientDaoImpl() {
        this.patientList = new ArrayList<>();
    }

    @Override
    public Patient create(Patient patient) {
        if (patient == null) throw new IllegalArgumentException("Patient was null");
        // todo: check the ssn should be unique
        patientList.add(patient);
        return patient;
    }

    @Override
    public Patient findBySsn(String Ssn) {
        if (Ssn == null) throw new IllegalArgumentException("Social security number was null");
        for ( Patient patient: patientList){
            if (patient.getSsn().equalsIgnoreCase(Ssn)) return patient;
        }
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return new ArrayList<>(patientList);
    }
}

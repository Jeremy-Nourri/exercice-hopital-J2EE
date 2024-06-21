package org.example.tphopitalj2ee.service;

import org.example.tphopitalj2ee.exception.PatientNotFoundException;
import org.example.tphopitalj2ee.model.Patient;
import org.example.tphopitalj2ee.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

public class PatientService {

    private PatientRepository patientRepository = new PatientRepository();


    public Patient create(String lastName, String firstName, String birthDate, String picture) {

        Patient patient = new Patient();
        patient.setLastName(lastName);
        patient.setFirstName(firstName);
        patient.setBirthDate(LocalDate.parse(birthDate));
        patient.setPicture(picture);
        patientRepository.add(patient);
        return patient;
    }

    public Patient findPatientById(long id) {

        Patient patient = patientRepository.findById(Patient.class, id);

        if (patient == null) {
            throw new PatientNotFoundException("Patient not found");
        } else {
            return patient;
        }
    }

    public Patient updatePatient(long id, String lastName, String firstName, String birthDate, String picture) {

        Patient patient = patientRepository.findById(Patient.class, id);

            patient.setLastName(lastName);
            patient.setFirstName(firstName);
            patient.setBirthDate(LocalDate.parse(birthDate));
            patient.setPicture(picture);
            patientRepository.update(patient);
            return patient;

    }

    public boolean deletePatient(long id) {

          Patient patient = patientRepository.findById(Patient.class, id);
           return patientRepository.delete(patient);
    }

    public boolean findSamePatient(String lastName, String firstName, String birthDate) {

        return patientRepository.findSamePatient(lastName, firstName, birthDate);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll(Patient.class);
    }


}

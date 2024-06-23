package org.example.tphopitalj2ee.service;

import org.example.tphopitalj2ee.exception.InvalidEmailOrPasswordException;
import org.example.tphopitalj2ee.model.Doctor;
import org.example.tphopitalj2ee.repository.BaseRepository;
import org.example.tphopitalj2ee.repository.DoctorRepository;

import java.util.ArrayList;

public class DoctorService {

    private DoctorRepository doctorRepository = new DoctorRepository();

    public Doctor signUp(String lastName, String firstName, String email, String password, String picture ) {



        Doctor doctor = new Doctor();
        doctor.setLastName(lastName);
        doctor.setFirstName(firstName);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setPicture(picture);
        doctor.setMedicalVisitList(new ArrayList<>());
        doctorRepository.add(doctor);

        return doctor;
    }

    public Doctor signIn(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null || !doctor.getPassword().equals(password)) {
            throw new InvalidEmailOrPasswordException("Invalid email or password");
        }
        return doctor;
    }

    public Doctor findById(long id) {
        return doctorRepository.findById(Doctor.class, id);
    }

}

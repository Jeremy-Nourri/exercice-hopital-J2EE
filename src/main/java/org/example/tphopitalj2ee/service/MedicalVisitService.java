package org.example.tphopitalj2ee.service;

import org.example.tphopitalj2ee.model.Doctor;
import org.example.tphopitalj2ee.model.MedicalVisit;
import org.example.tphopitalj2ee.model.Patient;
import org.example.tphopitalj2ee.repository.MedicalVisitRepository;

import java.time.LocalDate;

public class MedicalVisitService {

    MedicalVisitRepository medicalVisitRepository = new MedicalVisitRepository();
    PatientService patientService = new PatientService();
    DoctorService doctorService = new DoctorService();

    public void addMedicalVisit(LocalDate date, String doctorId, String patientId) {

        Patient patient = patientService.findPatientById(Long.parseLong(patientId));
        Doctor doctor = doctorService.findById(Long.parseLong(doctorId));

        MedicalVisit medicalVisit = new MedicalVisit();
        medicalVisit.setDate(date);
        medicalVisit.setPatient(patient);
        medicalVisit.setDoctor(doctor);

        medicalVisitRepository.add(medicalVisit);

    }
}

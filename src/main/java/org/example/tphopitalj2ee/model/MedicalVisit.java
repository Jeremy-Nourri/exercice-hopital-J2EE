package org.example.tphopitalj2ee.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medical_visit")
public class MedicalVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate date;

    @OneToOne(mappedBy = "medicalVisit")
    private MedicalPrescription medicalPrescription;

    @OneToMany(mappedBy = "medicalVisit")
    private List<CareSheet> careSheetList;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    public MedicalVisit() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MedicalPrescription getMedicalPrescription() {
        return medicalPrescription;
    }

    public void setMedicalPrescription(MedicalPrescription medicalPrescription) {
        this.medicalPrescription = medicalPrescription;
    }

    public List<CareSheet> getCareSheetList() {
        return careSheetList;
    }

    public void setCareSheetList(List<CareSheet> careSheetList) {
        this.careSheetList = careSheetList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

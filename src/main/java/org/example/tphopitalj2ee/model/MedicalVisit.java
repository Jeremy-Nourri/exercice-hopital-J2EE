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




}

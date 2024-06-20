package org.example.tphopitalj2ee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_prescription")
public class MedicalPrescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String medicine;

    private String posology;

    private String duration;

    @OneToOne
    @JoinColumn(name = "medical_visit_id")
    private MedicalVisit medicalVisit;


    public MedicalPrescription() {
    }
}

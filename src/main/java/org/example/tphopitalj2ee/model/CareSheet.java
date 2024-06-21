package org.example.tphopitalj2ee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "care_sheet")
public class CareSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    private String care;

    private String careDate;

    @ManyToOne
    @JoinColumn(name = "medical_visit_id")
    private MedicalVisit medicalVisit;

    public CareSheet() {
    }
}

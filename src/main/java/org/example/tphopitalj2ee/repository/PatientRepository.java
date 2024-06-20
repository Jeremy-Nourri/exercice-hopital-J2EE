package org.example.tphopitalj2ee.repository;

import org.example.tphopitalj2ee.model.Patient;
import org.hibernate.query.Query;

import java.time.LocalDate;

public class PatientRepository extends  BaseRepository<Patient>{

    public PatientRepository() {
        super(Patient.class);
    }

  public boolean findSamePatient(String lastName, String firstName, String birthDate) {

        String hql = "FROM Patient WHERE lastName = :lastName AND firstName = :firstName AND birthDate = :birthDate";
        Query<Patient> query = databaseConnectionManager.getSession().createQuery(hql, Patient.class);
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        query.setParameter("birthDate", LocalDate.parse(birthDate));
        return !query.list().isEmpty();
    }

}

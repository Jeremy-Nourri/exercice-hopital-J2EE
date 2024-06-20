package org.example.tphopitalj2ee.repository;

import org.example.tphopitalj2ee.model.Doctor;
import org.hibernate.query.Query;

public class DoctorRepository extends BaseRepository<Doctor> {

    public DoctorRepository() {
        super(Doctor.class);
    }

    public Doctor findByEmail(String email) {
        Doctor doctor = null;
        try {
            String hql = "FROM Doctor WHERE email = :email";
            Query<Doctor> query = databaseConnectionManager.getSession().createQuery(hql, Doctor.class);
            query.setParameter("email", email);
            doctor = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionManager.closeSession();
        }
        return doctor;

    }
}

package org.example.tphopitalj2ee.repository;

import org.example.tphopitalj2ee.model.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;


public class BaseRepository<T> {

    DatabaseConnectionManager databaseConnectionManager = DatabaseConnectionManager.getInstance();

    public BaseRepository(Class<T> className) {

    }


    public T add(T entity) {
        Session session = databaseConnectionManager.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            databaseConnectionManager.closeSession();
        }
        return entity;
    }

    public T update(T entity) {
        Session session = databaseConnectionManager.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            databaseConnectionManager.closeSession();
        }
        return entity;
    }

    public boolean delete(T entity) {
        Session session = databaseConnectionManager.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            databaseConnectionManager.closeSession();
        }
    }

    public T findById(Class<T> className, long id) {
        Session session = databaseConnectionManager.getSession();
        T entity = null;
        try {
            entity = session.find(className, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionManager.closeSession();
        }
        return entity;
    }

    public List<T> findAll(Class<T> className) {
        Session session = databaseConnectionManager.getSession();
        List<T> entities = null;
        try {
            Query<T> query = session.createQuery("from " + className);
            entities = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionManager.closeSession();
        }
        return entities;
    }

}




package dev.s2i.crudApp.dao;

import dev.s2i.crudApp.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;



@Transactional
@Component
public class PersonDAO {

    private final EntityManagerFactory factory;
    public PersonDAO() {
        factory = Persistence.createEntityManagerFactory("hibernateDemo");
    }


    public List<Person> getPeople() {
        EntityManager em = factory.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Person getPersonById(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            em.close();
        }
    }

    public void addPerson(Person person) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(person);
        tx.commit();
        em.close();
    }

    public void updatePerson(int id, Person person) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Person p = em.find(Person.class, id);
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        p.setEmail(person.getEmail());
        em.merge(person);
        tx.commit();
        em.close();
    }

    public void deletePerson(int id) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Person p = em.find(Person.class, id);
        em.remove(p);
        tx.commit();
        em.close();
    }


}

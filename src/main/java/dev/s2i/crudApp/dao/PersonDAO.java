package dev.s2i.crudApp.dao;

import dev.s2i.crudApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PERSON_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PERSON_ID,"Igor","Subbotin","s.2i@mail.ru"));
        people.add(new Person(++PERSON_ID,"Sarah","Conor","sara@mail.ru"));
        people.add(new Person(++PERSON_ID,"Greg", "Mackenroy","greg@mail.ru"));
        people.add(new Person(++PERSON_ID,"Sam", "Smith","sam@mail.ru"));
        people.add(new Person(++PERSON_ID,"Jack", "Daniels","jack@mail.ru"));
        people.add(new Person(++PERSON_ID,"James", "Bond","bond@mail.ru"));
    }

    public List<Person> people() {
        return people;
    }

    public Person getPersonById(int id) {
        for (Person p : people) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void addPerson(Person person) {
        person.setId(++PERSON_ID);
        people.add(person);
    }

    public void updatePerson(int id, Person person) {
        Person p = getPersonById(id);
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        p.setEmail(person.getEmail());

    }

    public void deletePerson(int id) {
        Person p = getPersonById(id);
        people.remove(p);
    }


}

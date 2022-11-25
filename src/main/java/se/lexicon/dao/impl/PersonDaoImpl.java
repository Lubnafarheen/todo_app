package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDao;
import se.lexicon.model.Person;
import se.lexicon.sequencer.PersonIdSequencer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {

    private List<Person> personData;

    private static PersonDaoImpl instance;

    private PersonDaoImpl() {
        personData = new ArrayList<>();
    }

    public static PersonDaoImpl getInstance() {
        if (instance == null) instance = new PersonDaoImpl();
        return instance;
    }

    @Override
    public Person create(Person model) {
        if (model == null) throw new IllegalArgumentException("Person was null");
        model.setId(PersonIdSequencer.nextId());
        personData.add(model);
        return model;
    }

    @Override
    public Person findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Person was null");
        for (Person person : personData) {
            if (person.getId().equals(id))
                return person;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return personData.remove(findById(id));
    }

    @Override
    public void update(Person model) {
        if (model == null) throw new IllegalArgumentException("Person update was null");
        for (Person personElements : personData) {
            if (personElements.getId().equals(model.getId())) {
                personElements.setFirstName(model.getFirstName());
                personElements.setLastName(model.getLastName());
                personElements.setAppUser(model.getAppUser());
                personElements.setAssignedTodos(model.getAssignedTodos());
                break;
            }
        }
    }

    @Override
    public List<Person> findAll() {
        return personData;
    }

    @Override
    public Optional<Person> findByUserName(String username) {
        if (username == null) throw new IllegalArgumentException("username was null");
        for (Person person : personData) {
            if (person.getAppUser().getUsername().equals(username))
                return Optional.of(person);
        }
        return Optional.empty();
    }
}

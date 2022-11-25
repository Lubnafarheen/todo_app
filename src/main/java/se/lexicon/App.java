package se.lexicon;


import se.lexicon.dao.AppUserDao;
import se.lexicon.dao.PersonDao;
import se.lexicon.dao.TodoItemDao;
import se.lexicon.dao.impl.AppUserDaoImpl;
import se.lexicon.dao.impl.PersonDaoImpl;
import se.lexicon.dao.impl.TodoItemDaoImpl;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.Role;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        // user data
        AppUser appUserData1 = new AppUser("test", "password", Role.ROLE_USER);
        AppUser appUserData2 = new AppUser("user2", "password", Role.ROLE_USER);
        AppUser appUserData3 = new AppUser("user3", "password", Role.ROLE_USER);

        AppUserDao appUserDao = AppUserDaoImpl.getInstance();
        AppUser createdAppUser1 = appUserDao.create(appUserData1);
        AppUser createdAppUser2 = appUserDao.create(appUserData2);
        AppUser createdAppUser3 = appUserDao.create(appUserData3);
        System.out.println(appUserDao.findAll());
        System.out.println("-------------------");

        AppUserDao appUserDao2 = AppUserDaoImpl.getInstance();
        System.out.println(appUserDao2.findAll());
        System.out.println("-------------------");

        Person personData1 = new Person("Lubna", "Farheen", appUserData1);
        personData1.setAppUser(createdAppUser1);

        PersonDao personDao = PersonDaoImpl.getInstance();
        Person createdPersonData1 = personDao.create(personData1);
        System.out.println(createdPersonData1.getAppUser());
        System.out.println("-------------------");

       Optional <Person> person = personDao.findByUserName("test");
        if(person.isPresent()) System.out.println(person.get());
        else System.out.println("Person not found");
        System.out.println("-------------------");

        TodoItem task1 = new TodoItem("TASK1", "Description", LocalDate.parse("2022-12-06"));
        task1.setAssignee(createdPersonData1);

        TodoItemDao todoItemDao = TodoItemDaoImpl.getInstance();
        TodoItem createdtask1 = todoItemDao.create(task1);
        System.out.println(todoItemDao.findAll());
        System.out.println(todoItemDao.findByDone(false));

    }

}

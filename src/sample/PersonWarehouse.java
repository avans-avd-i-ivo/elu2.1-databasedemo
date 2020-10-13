package sample;


import java.util.List;

public interface PersonWarehouse {
    void save(Person person);

    Person search(String socialSecurityNumber);

    void delete(Person person);

    void delete(String socialSecurityNumber);

    void deleteAll();

    List<Person> getAll();

}

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryPersonWarehouse implements ObservablePersonWarehouse {
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void save(Person person) {
        System.out.println("Saved: " + person);
        personList.add(person);

        System.out.println("List of persons:");
        for (Person p : personList) {
            System.out.println("\t" + p);
        }
    }

    @Override
    public Person search(String socialSecurityNumber) {
        Optional<Person> found = personList.stream().filter(p -> p.getSsn().equals(socialSecurityNumber)).findFirst();
        Person result = found.isEmpty() ? null : found.get();

        System.out.println(result==null ? "No person found" : "found: " + result);

        return result;
    }

    @Override
    public void delete(Person person) {
        personList = personList.stream().filter(p -> !p.equals(person)).collect(Collectors.toCollection(FXCollections::observableArrayList));
        System.out.println("Deleted: " + person);
    }

    @Override
    public void delete(String socialSecurityNumber) {
        personList = personList.stream().filter(p -> !p.getSsn().equals(socialSecurityNumber)).collect(Collectors.toCollection(FXCollections::observableArrayList));
        System.out.println("Deleted, person with ssn: " + socialSecurityNumber);
    }

    @Override
    public void deleteAll() {
        personList.clear();
        System.out.println("All persons deleted");
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public ObservableList<Person> getObservableList() {
        return personList;
    }
}

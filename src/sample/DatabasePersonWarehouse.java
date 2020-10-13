package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePersonWarehouse extends AbstractDatabaseWarehouse<Person> implements PersonWarehouse {

    @Override
    Person recordToEntity(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(1);
        String ssn = resultSet.getString(2);

        return new Person(name, ssn);
    }

    @Override
    public void save(Person person) {
        useStatement("insert into people value (?, ?)", statement -> {
            statement.setString(1, person.getName());
            statement.setString(2, person.getSsn());

            return statement.execute();
        });
    }

    @Override
    public Person search(String socialSecurityNumber) {
        return useStatement("select name, ssn from people where ssn = ?", statement -> {
            statement.setString(1, socialSecurityNumber);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return recordToEntity(resultSet);
            } else {
                return null;
            }
        });
    }

    @Override
    public List<Person> getAll() {
        return useStatement("select name, ssn from people", statement -> {
            ResultSet resultSet = statement.executeQuery("select name, ssn from people");
            List<Person> result = new ArrayList<>();

            while (resultSet.next()) {
                Person person = recordToEntity(resultSet);
                result.add(person);
            }

            return result;
        });
    }

    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(String socialSecurityNumber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}

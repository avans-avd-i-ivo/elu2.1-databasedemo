package sample;

import java.sql.*;

public abstract class AbstractDatabaseWarehouse<E> {

    @FunctionalInterface
    interface UsesStatement<R> {
        R apply(PreparedStatement statement) throws SQLException;
    }

    <R> R useStatement(String sql, UsesStatement<R> operator) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/person_warehouse", "root", "");
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            //noinspection UnnecessaryLocalVariable
            R result = operator.apply(statement);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    abstract E recordToEntity(ResultSet resultSet) throws SQLException;

}

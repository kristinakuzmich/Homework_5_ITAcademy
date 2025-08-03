package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.storage.api.IUserStorage;
import by.it_academy.jd2.storage.api.exceptions.StorageException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorageSQL implements IUserStorage {
    private final DataSource dataSource;

    public UserStorageSQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(User user) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO users_app.users(login, password, full_name, birth_date, registration_date, role)
                	VALUES (?, ?, ?, ?, ?, ?);
            """);
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setObject(4, user.getBirthDate());
            statement.setObject(5, user.getRegistrationDate());
            statement.setString(6, user.getRole());

            statement.executeUpdate();
        } catch (Exception e) {
            throw new StorageException("Ошибка добавления пользователя", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> results = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                    SELECT login, password, full_name, birth_date, registration_date, role
                	FROM users_app.users;
            """);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {

                results.add(User.builder()
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .fullName(resultSet.getString("full_name"))
                        .birthDate(resultSet.getDate("birth_date"))
                        .registrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime())
                        .role(resultSet.getString("role"))
                        .build());
            }
        } catch (Exception e){
            throw new StorageException("Ошибка получения данных о пользователях", e);
        }
        return results;
    }

    @Override
    public int countUsers() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM users_app.users");
         ResultSet resultSet = statement.executeQuery();) {
        while (resultSet.next()) {
            return resultSet.getInt(1);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

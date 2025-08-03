package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.storage.api.IMessageStorage;
import by.it_academy.jd2.storage.api.exceptions.StorageException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageStorageSQL implements IMessageStorage {
    private final DataSource dataSource;

    public MessageStorageSQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Message msg) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                INSERT INTO users_app.messages(from_user, to_user, text, send_time)
                	VALUES (?, ?, ?, ?);
            """);
        ) {
            statement.setString(1, msg.getFromUser());
            statement.setString(2, msg.getToUser());
            statement.setString(3, msg.getText());
            statement.setObject(4, msg.getSendTime());

            statement.executeUpdate();
        } catch (Exception e) {
            throw new StorageException("Ошибка добавления сообщения", e);
        }
    }

    @Override
    public List<Message> getAll() {
        List<Message> results = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("""
                    SELECT from_user, to_user, text, send_time
                	FROM users_app.messages;
            """);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {

                results.add(Message.builder()
                        .from(resultSet.getString("from_user"))
                        .to(resultSet.getString("to_user"))
                        .text(resultSet.getString("text"))
                        .sendTime(resultSet.getObject("send_time", LocalDateTime.class))
                        .build());
            }
        } catch (Exception e){
            throw new StorageException("Ошибка получения сообщения", e);
        }
        return results;
    }

    @Override
    public int countMessages() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM users_app.messages");
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

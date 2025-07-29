package by.it_academy.jd2.storage;

import by.it_academy.jd2.storage.api.exceptions.StorageException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class StorageFactory {
    private final static DataSource dataSource;

    static {
        String userDbUrl = System.getenv("USER_DB_URL");
        if(userDbUrl == null) {
            userDbUrl = "jdbc:postgresql://localhost:5433/it_academy";
        }
        String userDbUser = System.getenv("USER_DB_USER");
        if(userDbUser == null) {
            userDbUser = "postgres";
        }
        String userDbPassword = System.getenv("USER_DB_PASSWORD");
        if(userDbPassword == null) {
            userDbPassword = "postgres";
        }

        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass( "org.postgresql.Driver" );
            cpds.setJdbcUrl(userDbUrl );
            cpds.setUser(userDbUser);
            cpds.setPassword(userDbPassword);

            dataSource = cpds;
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private final static UserStorageSQL userStorage;

    private final static MessageStorageSQL messageStorage;

    static {
        userStorage = new UserStorageSQL(dataSource);
    }

    static { messageStorage = new MessageStorageSQL(dataSource);
    }

    public static UserStorageSQL getUserStorage() {
        return userStorage;
    }

    public static MessageStorageSQL getMessageStorage() {
        return messageStorage;
    }






}

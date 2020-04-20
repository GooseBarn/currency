package connector;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private static final String DB_PROPERTIES_FILE = "src/main/resources/db.properties";

    /**
     * Получение подключения к БД
     *
     * @return экземпляр {@link Connection}
     */
    public static Connection getConnection() throws SQLException, IOException {
        Properties connectionProps = new Properties();

        FileInputStream fileInputStream = new FileInputStream(DB_PROPERTIES_FILE);
        connectionProps.load(fileInputStream);

        return DriverManager.getConnection(connectionProps.getProperty("url"), connectionProps);
    }
}

package repository;

import connector.DBConnector;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SomeItemRepository {


   private void selectFromtable(List<Pair<String, Double>> items, String query) throws SQLException, IOException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            items.add(new Pair<String, Double>(
                    resultSet.getDate("date").toString(),
                    resultSet.getDouble("price")
            ));
        }
    }
}

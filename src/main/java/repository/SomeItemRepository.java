package repository;

import connector.DBConnector;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SomeItemRepository {


    public List<Pair<String, Double>> getPriceCurrencyFromTo(String nameCurrency, String from, String to) throws SQLException, IOException {
        List<Pair<String, Double>> items = new ArrayList<Pair<String, Double>>();
        String query = "select p.* \n" +
                "from public.\"price\" as p\n" +
                "where p.date >= \'"+from+"\'::DATE \n" +
                "\t\tand \n" +
                "\tp.date <= \'"+to+"\'::DATE \n" +
                "\tand p.currency = 1";
        selectFromtable(items, query);
        return items;
    }


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
        connection.close();
    }
}

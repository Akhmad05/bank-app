package ru.developer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.developer.DbConnection;
import ru.developer.TypeQuery;
import ru.developer.model.UsersInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    @Autowired
    private DbConnection dbConnection;

    public void executeQuery(String query, TypeQuery typeQuery) {
        try (Statement stmt = dbConnection.getConnection().createStatement()) {
            switch (typeQuery) {
                case CREATE:
                    stmt.execute(query);
                    break;
                case INSERT:
                    stmt.executeUpdate(query);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0); // Стоит ли останавливать JVM?
        }

    }

    public List<UsersInfo> getUser() {
        List<UsersInfo> usersInfo = new ArrayList<>();

        try (Statement stmt = dbConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT u.id, u.firstname, COUNT (*) AS amount FROM users AS u LEFT JOIN tasks AS t ON u.id = t.users_id GROUP BY u.id");
        ) {
            while (rs.next()) {
                usersInfo.add(new UsersInfo(rs.getInt("id"), rs.getString("firstname"), rs.getInt("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0); // Стоит ли останавливать JVM?
        }
        return usersInfo;
    }
}

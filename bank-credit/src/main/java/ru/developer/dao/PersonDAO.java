package ru.developer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.developer.DbConnection;
import ru.developer.model.UsersInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    @Autowired
    DbConnection dbConnection;

    private static Statement stmt;

    public List<UsersInfo> getUser() {

        List<UsersInfo> usersInfo = new ArrayList<>();

        try {
            stmt = dbConnection.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery("SELECT u.id, u.firstname, COUNT (*) AS amount FROM users AS u LEFT JOIN tasks AS t ON u.id = t.users_id GROUP BY u.id");

            while (rs.next()) {
                usersInfo.add(new UsersInfo(rs.getInt("id"), rs.getString("firstname"), rs.getInt("amount")));
            }
            stmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersInfo;
    }
}

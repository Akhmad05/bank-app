package ru.developer.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.developer.model.UsersInfo;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static Connection conn;
    private static Statement stmt;

    @Value("${urlDB}")
    private String urlDB;

    @Value("${usersTable}")
    private String usersTable;

    @Value("${tasksTable}")
    private String tasksTable;


    @PostConstruct
    public void init(){
        try {
            conn = DriverManager.getConnection(urlDB);
            stmt = conn.createStatement();

            stmt.execute(usersTable);
            stmt.execute(tasksTable);

            stmt.executeUpdate("INSERT INTO users VALUES(1, 'Ivan', 'Ivanov')" +
                                   ";INSERT INTO users VALUES(2, 'Maksim', 'Smirnov')" +
                                   ";INSERT INTO users VALUES(3, 'Anton', 'Anisimov')");


            stmt.executeUpdate("INSERT INTO tasks VALUES(1, 2, 'Give me a pen')" +
                                   ";INSERT INTO tasks VALUES(2, 2, 'Give me a table3')" +
                                   ";INSERT INTO tasks VALUES(3, 1, 'Give me a table3')" +
                                   ";INSERT INTO tasks VALUES(4, 3, 'Give me a table3')" +
                                   ";INSERT INTO tasks VALUES(5, 2, 'Give me a table')" +
                                   ";INSERT INTO tasks VALUES(6, 3, 'Give me a table3')" +
                                   ";INSERT INTO tasks VALUES(7, 2, 'Give me a table4')");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<UsersInfo> showInfoUsers() {

            List<UsersInfo> usersInfo = new ArrayList<>();

            try {
                ResultSet rs = stmt.executeQuery("SELECT u.id, u.firstname, COUNT (*) AS amount FROM users AS u LEFT JOIN tasks AS t ON u.id = t.users_id GROUP BY u.id");

                while (rs.next()) {
                    usersInfo.add(new UsersInfo( rs.getInt("id"), rs.getString("firstname"), rs.getInt("amount")));
                }

                return usersInfo;

            }catch (SQLException e){
                e.printStackTrace();
            }

            return null;
    }
}

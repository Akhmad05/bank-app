package ru.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderDmlCommand {

    @Autowired
    DbConnection dbConnection;

    private static Statement stmt;

    public void insert() {
        try {
            stmt = dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (InputStream resource = new ClassPathResource(
                "dmlcommand.sql").getInputStream();
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(resource))) {


            List<String> cmd = reader.lines()
                    .collect(Collectors.toList());

            for (String exec : cmd) {
                stmt.executeUpdate(exec);
            }

            stmt.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

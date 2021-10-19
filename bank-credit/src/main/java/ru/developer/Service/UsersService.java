package ru.developer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.developer.DbConnection;
import ru.developer.ReaderDmlCommand;
import ru.developer.dao.PersonDAO;
import ru.developer.model.UsersInfo;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    DbConnection dbConnection;

    @Autowired
    ReaderDmlCommand readerDmlCommand;

    private static Statement stmt;

    @Value("${usersTable}")
    private String usersTable;

    @Value("${tasksTable}")
    private String tasksTable;

    @PostConstruct
    public void initApp() {

        initDb();
        initContent();
    }

    private void initDb() {
        try {
            stmt = dbConnection.getConnection().createStatement();
            stmt.execute(usersTable);
            stmt.execute(tasksTable);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initContent() {
        readerDmlCommand.insert();
    }

    public List<UsersInfo> getUser() {
        return personDAO.getUser();
    }
}

package ru.developer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.developer.ReaderDmlCommand;
import ru.developer.TypeQuery;
import ru.developer.dao.PersonDAO;
import ru.developer.model.UsersInfo;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private ReaderDmlCommand readerDmlCommand;

    @Value("${queryCreateTable}")
    private String queryCreateTable;


    @PostConstruct
    public void initApp() {
        initDb();
        initContent();
    }

    private void initDb() {
        personDAO.executeQuery(queryCreateTable, TypeQuery.CREATE);
    }

    private void initContent() {
        personDAO.executeQuery(readerDmlCommand.getQueryFromFile(), TypeQuery.INSERT);
    }

    public List<UsersInfo> getUser() {
        return personDAO.getUser();
    }
}

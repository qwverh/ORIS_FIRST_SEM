package service;

import dao.VisitDao;
import model.Visit;

import java.sql.SQLException;

public class VisitService {
    private final VisitDao visitDao = new VisitDao();

    public int create(Visit v) throws SQLException {
        return visitDao.create(v);
    }

    public Visit findById(int id) throws SQLException {
        return visitDao.findById(id);
    }
}

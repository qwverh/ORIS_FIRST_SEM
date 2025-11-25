package service;

import dao.TeacherDao;
import model.Teacher;

import java.sql.SQLException;

public class TeacherService {
    private final TeacherDao teacherDao = new TeacherDao();

    public Teacher findByEmail(String email) throws SQLException {
        return teacherDao.findByEmail(email);
    }

    public int register(Teacher t) throws SQLException {
        return teacherDao.create(t);
    }
}

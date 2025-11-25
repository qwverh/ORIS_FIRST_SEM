package service;

import dao.StudentDao;
import model.Student;
import model.Teacher;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private final StudentDao studentDao = new StudentDao();

    public Student findByEmail(String email) throws SQLException {
        return studentDao.findByEmail(email);
    }

    public Student findById(int id) throws SQLException {
        return studentDao.findById(id);
    }

    public int register(Student s) throws SQLException {
        return studentDao.create(s);
    }

    public void updateStudent(Student student) throws SQLException {
        studentDao.update(student);
    }

    public void deleteStudent(int studentId) throws SQLException {
        studentDao.delete(studentId);
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        return studentDao.getAllTeachers();
    }

    public List<Student> findByTeacherId(int teacherId) throws SQLException {
        return studentDao.findByTeacherId(teacherId);
    }
}

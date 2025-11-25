package service;

import dao.StudentVisitDao;
import model.StudentVisit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentVisitService {
    private final StudentVisitDao studentVisitDao = new StudentVisitDao();

    public void create(StudentVisit sv) throws SQLException {
        studentVisitDao.create(sv);
    }

    public void updateStatus(int studentId, int visitId, String status) throws SQLException {
        studentVisitDao.updateStatus(studentId, visitId, status);
    }

    public List<StudentVisit> getVisitsByStudent(int studentId) throws SQLException {
        return studentVisitDao.getVisitsByStudent(studentId);
    }

    public List<Map<String, Object>> getPendingByTeacher(int teacherId) throws SQLException {
        return studentVisitDao.getPendingByTeacher(teacherId);
    }
}

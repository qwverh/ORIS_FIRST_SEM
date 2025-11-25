package dao;

import model.StudentVisit;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentVisitDao {

    public void create(StudentVisit sv) throws SQLException {
        String sql = "insert into student_visit (student_id, visit_id, status) values (?, ?, ?)";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, sv.getStudentId());
            ps.setInt(2, sv.getVisitId());
            ps.setString(3, sv.getStatus());
            ps.executeUpdate();
        }
    }

    public void updateStatus(int studentId, int visitId, String status) throws SQLException {
        String sql = "update student_visit set status = ? where student_id = ? and visit_id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, studentId);
            ps.setInt(3, visitId);
            ps.executeUpdate();
        }
    }

    public List<StudentVisit> getVisitsByStudent(int studentId) throws SQLException {
        String sql = "select sv.student_id, sv.visit_id, sv.status, v.visit_date, v.visit_time " +
                "from student_visit sv join visits v on sv.visit_id = v.id where sv.student_id = ? order by v.visit_date";
        List<StudentVisit> result = new ArrayList<>();
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    StudentVisit sv = new StudentVisit();
                    sv.setStudentId(rs.getInt("student_id"));
                    sv.setVisitId(rs.getInt("visit_id"));
                    sv.setStatus(rs.getString("status"));
                    sv.setVisitDate(rs.getDate("visit_date").toLocalDate());
                    sv.setVisitTime(rs.getTime("visit_time").toLocalTime());
                    result.add(sv);
                }
            }
        }
        return result;
    }

    public List<Map<String, Object>> getPendingByTeacher(int teacherId) throws SQLException {
        String sql = """
        select 
            s.id as student_id,
            s.full_name as student_name,
            s.group_number,
            s.course_number,
            v.id as visit_id,
            v.visit_date,
            v.visit_time,
            sv.status
        from students s
        join student_visit sv on s.id = sv.student_id
        join visits v on v.id = sv.visit_id
        where s.teacher_id = ? and sv.status = 'На рассмотрении'
        order by v.visit_date
        """;

        List<Map<String, Object>> res = new ArrayList<>();
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, teacherId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("studentId", rs.getInt("student_id"));
                    row.put("studentName", rs.getString("student_name"));
                    row.put("groupNumber", rs.getString("group_number"));
                    row.put("course", rs.getInt("course_number"));
                    row.put("visitId", rs.getInt("visit_id"));
                    row.put("visitDate", rs.getDate("visit_date"));
                    row.put("visitTime", rs.getTime("visit_time"));
                    row.put("status", rs.getString("status"));
                    res.add(row);
                }
            }
        }
        return res;
    }


}

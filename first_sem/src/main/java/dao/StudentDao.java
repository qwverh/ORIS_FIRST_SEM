package dao;

import model.Student;
import model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public Student findByEmail(String email) throws SQLException {
        String sql = "select id, full_name, email, password_hash, group_number, course_number, teacher_id from students where email = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setFullName(rs.getString("full_name"));
                    s.setEmail(rs.getString("email"));
                    s.setPasswordHash(rs.getString("password_hash"));
                    s.setGroupNumber(rs.getString("group_number"));
                    s.setCourseNumber(rs.getInt("course_number"));
                    int tid = rs.getInt("teacher_id");
                    if (rs.wasNull()) s.setTeacherId(null); else s.setTeacherId(tid);
                    return s;
                }
            }
        }
        return null;
    }

    public int create(Student s) throws SQLException {
        String sql = "insert into students (full_name, email, password_hash, group_number, course_number, teacher_id) values (?, ?, ?, ?, ?, ?) returning id";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getFullName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPasswordHash());
            ps.setString(4, s.getGroupNumber());
            ps.setInt(5, s.getCourseNumber());
            if (s.getTeacherId() == null) ps.setNull(6, Types.INTEGER); else ps.setInt(6, s.getTeacherId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id");
            }
        }
        return -1;
    }

    public Student findById(int id) throws SQLException {
        String sql = "select id, full_name, email, password_hash, group_number, course_number, teacher_id from students where id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setFullName(rs.getString("full_name"));
                    s.setEmail(rs.getString("email"));
                    s.setPasswordHash(rs.getString("password_hash"));
                    s.setGroupNumber(rs.getString("group_number"));
                    s.setCourseNumber(rs.getInt("course_number"));
                    int tid = rs.getInt("teacher_id");
                    if (rs.wasNull()) s.setTeacherId(null); else s.setTeacherId(tid);
                    return s;
                }
            }
        }
        return null;
    }

    public List<Student> findByTeacherId(int teacherId) throws SQLException {
        String sql = "select id, full_name, email, group_number, course_number from students where teacher_id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, teacherId);
            try (ResultSet rs = ps.executeQuery()) {
                List<Student> list = new ArrayList<>();
                while (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setFullName(rs.getString("full_name"));
                    s.setEmail(rs.getString("email"));
                    s.setGroupNumber(rs.getString("group_number"));
                    s.setCourseNumber(rs.getInt("course_number"));
                    list.add(s);
                }
                return list;
            }
        }
    }

    public void update(Student s) throws SQLException {
        String sql = "update students set full_name = ?, email = ?, group_number = ?, " +
                "course_number = ?, teacher_id = ? where id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.getFullName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getGroupNumber());
            ps.setInt(4, s.getCourseNumber());
            if (s.getTeacherId() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, s.getTeacherId());
            }
            ps.setInt(6, s.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "delete from students where id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        String sql = "select id, full_name, email from teachers order by full_name";
        List<Teacher> teachers = new ArrayList<>();
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setFullName(rs.getString("full_name"));
                t.setEmail(rs.getString("email"));
                teachers.add(t);
            }
        }
        return teachers;
    }
}

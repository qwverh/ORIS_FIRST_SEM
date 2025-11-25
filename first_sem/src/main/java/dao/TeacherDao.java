package dao;

import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao {

    public Teacher findByEmail(String email) throws SQLException {
        String sql = "select id, full_name, email, password_hash from teachers where email = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Teacher t = new Teacher();
                    t.setId(rs.getInt("id"));
                    t.setFullName(rs.getString("full_name"));
                    t.setEmail(rs.getString("email"));
                    t.setPasswordHash(rs.getString("password_hash"));
                    return t;
                }
            }
        }
        return null;
    }

    public int create(Teacher t) throws SQLException {
        String sql = "insert into teachers (full_name, email, password_hash) values (?, ?, ?) returning id";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getFullName());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getPasswordHash());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id");
            }
        }
        return -1;
    }
}

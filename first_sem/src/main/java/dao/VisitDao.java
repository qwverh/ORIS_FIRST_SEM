package dao;

import model.Visit;

import java.sql.*;

public class VisitDao {
    public int create(Visit v) throws SQLException {
        String sql = "insert into visits (visit_date, visit_time) values (?, ?) RETURNING id";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(v.getVisitDate()));
            if (v.getVisitTime() != null) ps.setTime(2, Time.valueOf(v.getVisitTime())); else ps.setNull(2, Types.TIME);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id");
            }
        }
        return -1;
    }


    public Visit findById(int id) throws SQLException {
        String sql = "select id, visit_date, visit_time from visits where id = ?";
        try (Connection c = DbConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Visit v = new Visit();
                    v.setId(rs.getInt("id"));
                    Date d = rs.getDate("visit_date");
                    if (d != null) v.setVisitDate(d.toLocalDate());
                    Time t = rs.getTime("visit_time");
                    if (t != null) v.setVisitTime(t.toLocalTime());
                    return v;
                }
            }
        }
        return null;
    }
}

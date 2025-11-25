package model;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class StudentVisit {
    private int studentId;
    private int visitId;
    private String status;
    private LocalDate visitDate;
    private LocalTime visitTime;

    public StudentVisit() {
    }

    public StudentVisit(int studentId, int visitId, String status) {
        this.studentId = studentId;
        this.visitId = visitId;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }
}

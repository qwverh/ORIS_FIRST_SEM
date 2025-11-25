package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private int id;
    private LocalDate visitDate;
    private LocalTime visitTime;


    public Visit() {
    }

    public Visit(int id, LocalDate visitDate, LocalTime visitTime) {
        this.id = id;
        this.visitDate = visitDate;
        this.visitTime = visitTime;

    }

    public Visit(LocalDate visitDate, LocalTime visitTime) {
        this.visitDate = visitDate;
        this.visitTime = visitTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

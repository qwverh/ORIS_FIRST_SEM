package model;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private String passwordHash;
    private String groupNumber;
    private int courseNumber;
    private Integer teacherId;


    public Student() {
    }

    public Student(String fullName, String email, String passwordHash, String groupNumber, int courseNumber, Integer teacherId) {
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.groupNumber = groupNumber;
        this.courseNumber = courseNumber;
        this.teacherId = teacherId;
    }

    public Student(int id, String fullName, String email, String passwordHash, String groupNumber, int courseNumber, Integer teacherId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.groupNumber = groupNumber;
        this.courseNumber = courseNumber;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}

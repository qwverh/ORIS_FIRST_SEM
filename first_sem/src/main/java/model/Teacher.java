package model;

public class Teacher {
    private int id;
    private String fullName;
    private String email;
    private String passwordHash;

    public Teacher() {
    }

    public Teacher(String fullName, int id, String email, String passwordHash) {
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Teacher(String fullName, String email, String passwordHash) {
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
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
}

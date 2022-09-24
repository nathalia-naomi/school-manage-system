package school.manage.system.models;

import java.time.LocalDate;
import java.util.HashSet;

public class Teacher {

    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private HashSet<Subject> subjects;

    public Teacher(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Teacher(String firstName, String lastName, String cpf, String email, LocalDate birthDate, HashSet<Subject> subjects) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setEmail(email);
        setBirthDate(birthDate);
        setSubjects(subjects);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public HashSet<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashSet<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

}

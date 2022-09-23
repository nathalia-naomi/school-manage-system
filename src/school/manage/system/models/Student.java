package school.manage.system.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private List<Subject> subjects;
    private HashMap<Subject, Grade> reportCard;

    public Student(String firstName, String lastName, String cpf, String email, LocalDate birthDate, List<Subject> subjects) {
        setFirstName(firstName);
        setLastName(lastName);
        setCpf(cpf);
        setEmail(email);
        setBirthDate(birthDate);
        setSubjects(subjects);
        generateReportCard(subjects);
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public HashMap<Subject, Grade> getReportCard() {
        return reportCard;
    }

    private void generateReportCard(List<Subject> subjects) {
        for (Subject subject : subjects) {
            reportCard.put(subject, new Grade());
        }
    }
}
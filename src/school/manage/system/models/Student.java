package school.manage.system.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Student {

    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private HashSet<Subject> subjects;
    private HashMap<Subject, Grade> reportCard = new HashMap<>();

    public Student(String name, String cpf) {
        setName(name);
        setCpf(cpf);
        setEmail("");
        setSubjects(new HashSet<Subject>());
        generateReportCard(new HashSet<Subject>());
    }

    public Student(String name, String cpf, String email, LocalDate birthDate, HashSet<Subject> subjects) {
        setName(name);
        setCpf(cpf);
        setEmail(email);
        setBirthDate(birthDate);
        setSubjects(subjects);
        generateReportCard(subjects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        updateReportCard();
    }

    public void enrollment(Subject newSubject) {
        subjects.add(newSubject);
        updateReportCard();
    }

    public void unenrollment(Subject canceledSubject) {
        subjects.remove(canceledSubject);
        updateReportCard();
    }

    public HashMap<Subject, Grade> getReportCard() {
        return reportCard;
    }

    private void generateReportCard(HashSet<Subject> subjects) {
        for (Subject subject : subjects) {
            reportCard.put(subject, new Grade());
        }
    }

    public void updateReportCard() {
        for (Subject subject : subjects) {
            if (reportCard.get(subject) == null) {
                reportCard.put(subject, new Grade());
            }
        }

        for (Subject enrolledSubject : reportCard.keySet()) {
            if (!subjects.contains(enrolledSubject)) {
                reportCard.remove(enrolledSubject);
            }
        }
    }
}
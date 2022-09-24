package school.manage.system.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Student {

    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
    private LocalDate birthDate;
    private HashSet<Subject> subjects;
    private HashMap<Subject, Grade> reportCard = new HashMap<>();

    public Student(String firstName, String cpf) {
        setFirstName(firstName);
        setLastName("");
        setCpf(cpf);
        setEmail("");
        setSubjects(new HashSet<Subject>());
        generateReportCard(new HashSet<Subject>());
    }

    public Student(String firstName, String lastName, String cpf, String email, LocalDate birthDate, HashSet<Subject> subjects) {
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
            System.out.println(reportCard.keySet());
            System.out.println(enrolledSubject);
            System.out.println(subjects);

            if (!subjects.contains(enrolledSubject)) {
                reportCard.remove(enrolledSubject);
            }
        }
    }
}
package school.manage.system.models;

import java.time.LocalDate;

public class Teacher {

    private String name;
    private String cpf;
    private String email;
    private LocalDate birthDate;

    public Teacher(String name, String cpf) {
        setName(name);
        setCpf(cpf);
        setEmail("");
    }

    public Teacher(String name, String cpf, String email, LocalDate birthDate) {
        setName(name);
        setCpf(cpf);
        setEmail(email);
        setBirthDate(birthDate);
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

}

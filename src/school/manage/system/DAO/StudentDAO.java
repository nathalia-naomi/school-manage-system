package school.manage.system.DAO;

import school.manage.system.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentDAO implements DAO<Student> {

    private List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> get(long id) {
        return Optional.ofNullable(students.get((int) id));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student, String[] params) {
        student.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        student.setCpf(Objects.requireNonNull(params[1], "CPF cannot be null"));
        student.setEmail(params[2] != null ? params[2] : "");
        student.setBirthDate(params[3] != null ? LocalDate.parse(params[3]) : LocalDate.parse(""));

        students.add(student);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }

}

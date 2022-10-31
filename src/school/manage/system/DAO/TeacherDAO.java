package school.manage.system.DAO;

import school.manage.system.models.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TeacherDAO implements DAO<Teacher> {

    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public Optional<Teacher> get(long id) {
        return Optional.ofNullable(teachers.get((int) id));
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void save(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void update(Teacher teacher, String[] params) {
        teacher.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        teacher.setCpf(Objects.requireNonNull(params[1], "CPF cannot be null"));
        teacher.setEmail(params[2] != null ? params[2] : "");
        teacher.setBirthDate(params[3] != null ? LocalDate.parse(params[3]) : LocalDate.parse(""));

        teachers.add(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teachers.remove(teacher);
    }

}

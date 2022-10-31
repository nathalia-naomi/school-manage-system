package school.manage.system.DAO;

import school.manage.system.models.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SubjectDAO implements DAO<Subject> {

    private List<Subject> subjects = new ArrayList<>();

    @Override
    public Optional<Subject> get(long id) {
        return Optional.ofNullable(subjects.get((int) id));
    }

    @Override
    public List<Subject> getAll() {
        return subjects;
    }

    @Override
    public void save(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void update(Subject subject, String[] params) {
        subject.setName(Objects.requireNonNull(params[0], "Name cannot be null"));

        subjects.add(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjects.remove(subject);
    }

}

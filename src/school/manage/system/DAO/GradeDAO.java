package school.manage.system.DAO;

import school.manage.system.models.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Double.valueOf;

public class GradeDAO implements DAO<Grade> {

    private List<Grade> grades = new ArrayList<>();

    @Override
    public Optional<Grade> get(long id) {
        return Optional.ofNullable(grades.get((int) id));
    }

    @Override
    public List<Grade> getAll() {
        return grades;
    }

    @Override
    public void save(Grade grade) {
        grades.add(grade);
    }

    @Override
    public void update(Grade grade, String[] params) {
        grade.setFirst(params[0] != null ? valueOf(params[0]) : 0.0);
        grade.setSecond(params[0] != null ? valueOf(params[1]) : 0.0);
        grade.setThird(params[0] != null ? valueOf(params[2]) : 0.0);
        grade.setFourth(params[0] != null ? valueOf(params[3]) : 0.0);

        grades.add(grade);
    }

    @Override
    public void delete(Grade grade) {
        grades.remove(grade);
    }

}

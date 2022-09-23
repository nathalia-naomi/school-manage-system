package school.manage.system.models;

public class Subject {

    private Integer id;
    private String name;
    private Teacher teacher;

    public Subject(Integer id, String name, Teacher teacher) {
        setId(id);
        setName(name);
        setTeacher(teacher);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

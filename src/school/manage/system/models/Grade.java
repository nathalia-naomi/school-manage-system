package school.manage.system.models;

import java.util.LinkedHashMap;

public class Grade {

    private LinkedHashMap<String, Double> grades = new LinkedHashMap<>();

    public Grade() {
        grades.put("First", 0.0);
        grades.put("Second", 0.0);
        grades.put("Third", 0.0);
        grades.put("Fourth", 0.0);
        grades.put("Average", 0.0);
    }

    public Grade(LinkedHashMap<String, Double> grades) {
        this.grades = grades;
    }

    public Grade(Double first, Double second, Double third, Double fourth) {
        grades.put("First", first);
        grades.put("Second", second);
        grades.put("Third", third);
        grades.put("Fourth", fourth);
        updateAverage();
    }

    public LinkedHashMap<String, Double> getGrades() {
        return grades;
    }

    public void setGrades(LinkedHashMap<String, Double> grades) {
        this.grades = grades;
    }

    public Double getFirst() {
        return grades.get("First");
    }

    public void setFirst(Double first) {
        grades.put("First", first);
        updateAverage();
    }

    public Double getSecond() {
        return grades.get("Second");
    }

    public void setSecond(Double second) {
        grades.put("Second", second);
        updateAverage();
    }

    public Double getThird() {
        return grades.get("Third");
    }

    public void setThird(Double third) {
        grades.put("Third", third);
        updateAverage();
    }

    public Double getFourth() {
        return grades.get("Fourth");
    }

    public void setFourth(Double fourth) {
        grades.put("Fourth", fourth);
        updateAverage();
    }

    private void updateAverage() {
        Double average = (getFirst() + getSecond() + getThird() + getFourth()) / 4;
        grades.put("Average", average);
    }

    public Double getAverage() {
        return grades.get("Average");
    }

    public void printGradeInfo() {
        System.out.println("First:\t" + getFirst());
        System.out.println("Second:\t" + getSecond());
        System.out.println("Third:\t" + getThird());
        System.out.println("Fourth:\t" + getFourth());
        System.out.println("Average:\t" + getAverage());
    }

}

package test.school.manage.system.models;

import school.manage.system.models.Subject;
import school.manage.system.models.Teacher;

import java.util.ArrayList;

import static test.school.manage.system.TestUtils.separator;
import static test.school.manage.system.TestUtils.testPassedOrFailed;
import static test.school.manage.system.TestUtils.validation;

public class TestSubjectClass {

    private static Integer id = 10;
    private static String name = "Math";
    private static Teacher teacher = new Teacher("", "");

    public static void testConstructor1() {

        System.out.println(separator);
        System.out.println("# Test 1 - Constructor 1");

        ArrayList<Boolean> testKeys = new ArrayList<>();
        Subject testSubject = new Subject(id, name);

        testKeys.add(validation(testSubject.getId(), id));
        testKeys.add(validation(testSubject.getName(), name));
        testKeys.add(validation(testSubject.getTeacher(), teacher));

        testPassedOrFailed(!testKeys.contains(false));
    }

    public static void testConstructor2() {

        System.out.println(separator);
        System.out.println("# Test 2 - Constructor 2");

        ArrayList<Boolean> testKeys = new ArrayList<>();

        Teacher testTeacher = new Teacher("Vinicius", "Oliveira");
        Subject testSubject = new Subject(id, name, testTeacher);

        validation(testSubject.getId(), id);
        validation(testSubject.getName(), name);
        validation(testSubject.getTeacher(), testSubject);

        testPassedOrFailed(!testKeys.contains(false));

    }

    public static void main(String[] args) {
        testConstructor1();
        testConstructor2();
    }
}

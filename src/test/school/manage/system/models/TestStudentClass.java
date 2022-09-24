package test.school.manage.system.models;

import school.manage.system.models.Grade;
import school.manage.system.models.Student;
import school.manage.system.models.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static test.school.manage.system.TestUtils.separator;
import static test.school.manage.system.TestUtils.testPassedOrFailed;
import static test.school.manage.system.TestUtils.validation;

public class TestStudentClass {

    private static String firstName = "Vinicius";
    private static String lastName = "Oliveira";
    private static String cpf = "123.456.789-00";
    private static String email = "email@email.com";
    private static LocalDate birthDate = LocalDate.of(2000, 01, 01);
    private static HashSet<Subject> subjects = new HashSet<>();
    private static HashMap<Subject, Grade> reportCard = new HashMap<>();

    public static void testStudentConstructor1() {
        System.out.println("\n" + separator);
        System.out.println("\n# Test 1 - Constructor 1");

        ArrayList<Boolean> testAttributes = new ArrayList<>();
        Student testStudent = new Student(firstName, cpf);
        testAttributes.add(validation(testStudent.getFirstName(), firstName));
        testAttributes.add(validation(testStudent.getLastName(), ""));
        testAttributes.add(validation(testStudent.getCpf(), cpf));
        testAttributes.add(validation(testStudent.getEmail(), ""));
        testAttributes.add(validation(testStudent.getBirthDate(), null));
        testAttributes.add(validation(testStudent.getSubjects(), new HashSet<>()));

        testPassedOrFailed(!testAttributes.contains(false));
    }

    public static void testStudentConstructor2() {
        System.out.println("\n" + separator);
        System.out.println("# Test 2 - Constructor 2");

        ArrayList<Boolean> testAttributes = new ArrayList<>();
        Student testStudent = new Student(firstName, lastName, cpf, email, birthDate, subjects);
        testAttributes.add(validation(testStudent.getFirstName(), firstName));
        testAttributes.add(validation(testStudent.getLastName(), lastName));
        testAttributes.add(validation(testStudent.getCpf(), cpf));
        testAttributes.add(validation(testStudent.getEmail(), email));
        testAttributes.add(validation(testStudent.getBirthDate(), birthDate));
        testAttributes.add(validation(testStudent.getSubjects(), subjects));

        testPassedOrFailed(!testAttributes.contains(false));
    }

    public static void testEnrollment() {
        System.out.println("\n"+separator);
        System.out.println("# Test 3 - Enrollment");

        Student testStudent = new Student(firstName, cpf);
        Subject subject1 = new Subject(0001, "MATH");
        Subject subject2 = new Subject(0002, "ENGLISH");
        Subject subject3 = new Subject(0003, "SCIENCE");
        HashSet<Subject> testSubjects = new HashSet<>();

        System.out.println("#0 - Init value: " + testStudent.getSubjects());
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

        System.out.println("#1 - Test setSubjects() : " + testStudent.getSubjects());
        testSubjects.add(subject1);
        testStudent.setSubjects(testSubjects);
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

        System.out.println("#2 - Test enrollment new subject : " + testStudent.getSubjects());
        testSubjects.add(subject2);
        testStudent.enrollment(subject2);
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

        System.out.println("#2.1 - Test enrollment existing subject : " + testStudent.getSubjects());
        testSubjects.add(subject1);
        testStudent.enrollment(subject1);
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

        System.out.println("#3 - Test unenrollment: " + testStudent.getSubjects());
        testSubjects.remove(subject1);
        testStudent.unenrollment(subject1);
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

        System.out.println("#3.1 - Test unenrollment non-existing subject: " + testStudent.getSubjects());
        testSubjects.remove(subject3);
        testStudent.unenrollment(subject3);
        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

    }
//
//    public static void testGenerateReportCardMethod() {
//        System.out.println(separator);
//        System.out.println("# Test 3 - Generate Report Card");
//        testPassedOrFailed(validation(testStudent.getSubjects(), testSubjects));

//        subjects.add(new Subject("Math"));
//    }

    public static void main(String[] args) {
        testStudentConstructor1();
        testStudentConstructor2();
        testEnrollment();
    }

}

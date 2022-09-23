package test.school.manage.system.models;

import school.manage.system.models.Grade;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TestGradeClass {

    public static final String separator = "--------------------------------------------------------------------------";
    private static Double average;
    private static LinkedHashMap<String, Double> expectedGrade = new LinkedHashMap<>();

    public static void setExpectedGrade(Double first, Double second, Double third, Double fourth) {

        expectedGrade.put("First", first);
        expectedGrade.put("Second", second);
        expectedGrade.put("Third", third);
        expectedGrade.put("Fourth", fourth);

        average = (first + second + third + fourth) / 4;
        expectedGrade.put("Average", average);
    }

    public static void testPassedOrFailed(Boolean validation) {

        if (validation) {
            System.out.println("## Test passed");
        } else System.out.println("## Test failed");
    }

    public static boolean validation(Double value, Double expected) {

        if (!(value.equals(expected))) {
            System.out.println("## Values do not match");
            System.out.println("## Expected: " + expected + " - Value: " + value);
            return false;
        } else {
            System.out.println("## Values match");
            return true;
        }
    }

    public static void validateGrade(Grade grade) {

        ArrayList<Boolean> testKeys = new ArrayList<>();

        for (String gradeTestKey : grade.getGrades().keySet()) {
            System.out.println("\n# Key: " + gradeTestKey);
            Double value = grade.getGrades().get(gradeTestKey);
            Double expected = expectedGrade.get(gradeTestKey);

            testKeys.add(validation(value, expected));
        }

        testPassedOrFailed(!testKeys.contains(false));
    }

    public static void testGradeConstructor1() {

        System.out.println(separator);
        System.out.println("# Test 1 - Constructor 1");

        setExpectedGrade(0.0, 0.0, 1.0, 0.0);
        Grade gradeTest = new Grade();

        validateGrade(gradeTest);
    }

    public static void testGradeConstructor2() {

        System.out.println(separator);
        System.out.println("# Test 2 - Constructor 2");

        setExpectedGrade(1.0, 2.0, 3.0, 4.0);
        Grade gradeTest = new Grade(expectedGrade);

        validateGrade(gradeTest);
    }

    public static void testGradeConstructor3() {

        System.out.println(separator);
        System.out.println("# Test 3 - Constructor 3");

        setExpectedGrade(1.0, 2.0, 3.0, 4.0);
        Grade gradeTest = new Grade(1.0, 2.0, 3.0, 4.0);

        validateGrade(gradeTest);
    }

    public static void testUpdateAverage() {

        System.out.println(separator);
        System.out.println("# Test 4 - Update Average Method");

        setExpectedGrade(0.0, 0.0, 0.0, 0.0);
        Double expectedAverage1 = expectedGrade.get("Average");

        Grade testGrade = new Grade();
        Double testAverage1 = testGrade.getAverage();

        testPassedOrFailed(validation(testAverage1, expectedAverage1));

        Double newValue = 4.0;

        setExpectedGrade(newValue, newValue, newValue, newValue);
        testGrade.setFirst(newValue);
        testGrade.setSecond(newValue);
        testGrade.setThird(newValue);
        testGrade.setFourth(newValue);

        Double expectedAverage2 = expectedGrade.get("Average");
        Double testAverage2 = testGrade.getAverage();

        testPassedOrFailed(validation(testAverage2, expectedAverage2));
    }

    public static void testSetters() {

        System.out.println(separator);
        System.out.println("# Test 5 - Test Setters");

        Double newValue = 5.0;
        Grade gradeTest = new Grade();

        System.out.println("\n# Test setFirst");
        gradeTest.setFirst(newValue);
        testPassedOrFailed(validation(gradeTest.getFirst(), newValue));

        System.out.println("\n# Test setSecond");
        gradeTest.setSecond(newValue);
        testPassedOrFailed(validation(gradeTest.getSecond(), newValue));

        System.out.println("\n# Test setThird");
        gradeTest.setThird(newValue);
        testPassedOrFailed(validation(gradeTest.getThird(), newValue));

        System.out.println("\n# Test setFourth");
        gradeTest.setFourth(newValue);
        testPassedOrFailed(validation(gradeTest.getFourth(), newValue));
    }

    public static void main(String[] args) {

        System.out.println(separator);
        System.out.println("Test Grade Class");

        testGradeConstructor1();
        testGradeConstructor2();
        testGradeConstructor3();
        testUpdateAverage();
        testSetters();
    }
}

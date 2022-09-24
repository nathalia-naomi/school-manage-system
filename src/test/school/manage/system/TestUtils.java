package test.school.manage.system;

import school.manage.system.models.Grade;
import school.manage.system.models.Subject;

import java.util.Objects;

public class TestUtils {

    public static final String separator = "--------------------------------------------------------------------------";
    public static boolean validation(Object value, Object expected) {

        if (!(Objects.equals(value, expected))) {
            System.out.println("## Values do not match");
            System.out.println("## Expected: " + expected + " - Value: " + value);
            return false;
        } else {
            System.out.println("## Values match");
            return true;
        }
    }

    public static void testPassedOrFailed(Boolean validation) {

        if (validation) {
            System.out.println("\n### Test passed");
        } else System.out.println("\n### Test failed");
    }

    public static void main(String[] args) {
        Subject test = new Subject(01, "math");
        System.out.println(test);
    }
}

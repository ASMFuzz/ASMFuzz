import java.util.ArrayList;

public class MyJVMTest_15138 {

    static String methodName = "z7NXR8ik+;";

    static String priorityList = "=UOEE5ynfS";

    static String tags = "Jq+Nx9Z{p?";

    static String expectedTags = "^@}-RQ.e# ";

    static String actualTags = "n|~!\\YF>Ei";

    String showErrorMessage(String methodName, String priorityList, String tags, String expectedTags, String actualTags) {
        System.out.println("\nIncorrect " + methodName + " result.");
        System.out.println("  Priority list  :  " + priorityList);
        System.out.println("  Language tags  :  " + tags);
        System.out.println("  Expected value : " + expectedTags);
        System.out.println("  Actual value   : " + actualTags);
        return tags;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15138().showErrorMessage(methodName, priorityList, tags, expectedTags, actualTags);
    }
}

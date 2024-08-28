import java.util.ArrayList;

public class MyJVMTest_2772 {

    static String methodName = ".\"c*XXr\\k;";

    static String priorityList = "R4tXn,n*'A";

    static String tags = "aR<]/UZhZK";

    static String expectedTags = "[e!Ff;(hc+";

    static String actualTags = "AH,:\"Vg~fv";

    static boolean err = false;

    String showErrorMessage(String methodName, String priorityList, String tags, String expectedTags, String actualTags) {
        System.err.println("\nIncorrect " + methodName + " result.");
        System.err.println("  Priority list  :  " + priorityList);
        System.err.println("  Language tags  :  " + tags);
        System.err.println("  Expected value : " + expectedTags);
        System.err.println("  Actual value   : " + actualTags);
        return tags;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2772().showErrorMessage(methodName, priorityList, tags, expectedTags, actualTags);
    }
}

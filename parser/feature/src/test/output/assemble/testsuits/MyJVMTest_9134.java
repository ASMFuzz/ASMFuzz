import java.util.ArrayList;

public class MyJVMTest_9134 {

    static String methodName = "hBVW\"Em(FH";

    static String priorityList = "%]i16{E|%#";

    static String tags = "V$9^+M-m<I";

    static String expectedTags = "^>X5Pn-G.v";

    static String actualTags = "i1p`:tCVLm";

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
        new MyJVMTest_9134().showErrorMessage(methodName, priorityList, tags, expectedTags, actualTags);
    }
}

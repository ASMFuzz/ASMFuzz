import java.util.ArrayList;

public class MyJVMTest_12063 {

    static String methodName = "?lrc?QKl>G";

    static String priorityList = "QuUA;Og=',";

    static String tags = "n(z2|8n}dM";

    static String expectedTags = "=I4K/vYrQ|";

    static String actualTags = "A {W5h5N)3";

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
        new MyJVMTest_12063().showErrorMessage(methodName, priorityList, tags, expectedTags, actualTags);
    }
}

import java.util.ArrayList;

public class MyJVMTest_5699 {

    static String methodName = "SIPI.c8f12";

    static String priorityList = "Z+/f%tlF x";

    static String tags = "4[:]+z\"R9 ";

    static String expectedTags = "A_Hiq0?v.G";

    static String actualTags = "L$ZPHVak\\*";

    String showErrorMessage(String methodName, String priorityList, String tags, String expectedTags, String actualTags) {
        System.out.println("\nIncorrect " + methodName + " result.");
        System.out.println("  Priority list  :  " + priorityList);
        System.out.println("  Language tags  :  " + tags);
        System.out.println("  Expected value : " + expectedTags);
        System.out.println("  Actual value   : " + actualTags);
        return tags;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5699().showErrorMessage(methodName, priorityList, tags, expectedTags, actualTags);
    }
}

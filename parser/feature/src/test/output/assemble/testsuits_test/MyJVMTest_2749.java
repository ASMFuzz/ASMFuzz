import java.text.*;

public class MyJVMTest_2749 {

    static String s1 = "([uV^SkOJ!";

    static String s2 = ".}pd@ZRJw1";

    static boolean err = false;

    String test1(String s1, String s2) {
        RuleBasedCollator col = null;
        try {
            col = new RuleBasedCollator("< a < b");
        } catch (ParseException e) {
            err = true;
            System.err.println(e);
        }
        try {
            col.compare("foo", "bar");
            col.compare(s1, s2);
            err = true;
            System.err.println("No exception was thrown for compare(" + s1 + ", " + s2 + ").");
        } catch (NullPointerException e) {
            System.out.println("NPE was thrown as expected for compare(" + s1 + ", " + s2 + ").");
        } catch (Exception e) {
            err = true;
            System.err.println("Unexpected exception was thrown for compare(" + s1 + ", " + s2 + "): " + e);
        }
        return s2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2749().test1(s1, s2);
    }
}

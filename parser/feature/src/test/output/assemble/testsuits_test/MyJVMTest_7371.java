public class MyJVMTest_7371 {

    static String s1 = "IJ'_Za1.W?";

    static String s2 = "[as-C@=Jj7";

    String checkEqual(String s1, String s2) {
        if (!s1.equals(s2))
            throw new RuntimeException("Unmatched strings: s1 = " + s1 + " s2 = " + s2);
        return s2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7371().checkEqual(s1, s2);
    }
}

public class MyJVMTest_16901 {

    static String s1 = "s,e*]Az!i7";

    static String s2 = "3hOS->vX8-";

    String checkEqual(String s1, String s2) {
        if (!s1.equals(s2))
            throw new RuntimeException("Unmatched strings: s1 = " + s1 + " s2 = " + s2);
        return s2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16901().checkEqual(s1, s2);
    }
}

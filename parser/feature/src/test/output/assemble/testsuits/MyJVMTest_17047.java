public class MyJVMTest_17047 {

    static String s1 = "\\9|dWCFQ[5";

    static String s2 = "e;adG>mKMX";

    String checkUnequal(String s1, String s2) {
        if (s1.equals(s2))
            throw new RuntimeException("Unexpected matched strings: " + s1);
        return s1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17047().checkUnequal(s1, s2);
    }
}

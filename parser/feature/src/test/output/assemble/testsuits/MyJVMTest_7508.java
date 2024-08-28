public class MyJVMTest_7508 {

    static String s1 = "4h^xeyM)o\"";

    static String s2 = "PI5/1}.!M1";

    String checkUnequal(String s1, String s2) {
        if (s1.equals(s2))
            throw new RuntimeException("Unexpected matched strings: " + s1);
        return s1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7508().checkUnequal(s1, s2);
    }
}

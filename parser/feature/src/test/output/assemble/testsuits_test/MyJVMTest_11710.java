public class MyJVMTest_11710 {

    static String why = "N#{t[\\npfg";

    static String lastFailure = "@9m+mX;lur";

    static int failureCount = 0;

    String fail(String why) {
        System.out.println("FAIL: " + why);
        lastFailure = why;
        failureCount++;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11710().fail(why);
    }
}

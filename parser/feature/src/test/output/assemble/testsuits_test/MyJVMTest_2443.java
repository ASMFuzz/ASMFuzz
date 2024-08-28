public class MyJVMTest_2443 {

    static String why = ",F'*x}E7$U";

    static String lastFailure = " %\"=KSv2-)";

    static int failureCount = 7;

    String fail(String why) {
        System.out.println("FAIL: " + why);
        lastFailure = why;
        failureCount++;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2443().fail(why);
    }
}

public class MyJVMTest_17689 {

    static String what = ":zA(jPE(U&";

    static int failures = 0;

    String failure(String what) {
        System.out.println("FAILED: " + what);
        failures++;
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17689().failure(what);
    }
}

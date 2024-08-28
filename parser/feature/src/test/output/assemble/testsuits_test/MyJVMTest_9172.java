public class MyJVMTest_9172 {

    static int iter = 1000;

    String helpGetStackTraceExtended() {
        return "Check the jvmtiGetStackTraceExtended API for at least 1 jitted frame after a relatively large number of iterations " + "Added as a unit test for J9 VM design ID 771";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9172().helpGetStackTraceExtended());
    }
}

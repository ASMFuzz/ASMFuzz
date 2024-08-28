public class MyJVMTest_2727 {

    static int iter = 10000;

    String helpGetThreadListStackTracesExtended() {
        return "Check the jvmtiGetThreaListdStackTracesExtended API for at least 1 jitted frame after a relatively large number of iterations " + "Added as a unit test for J9 VM design ID 771";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2727().helpGetThreadListStackTracesExtended());
    }
}

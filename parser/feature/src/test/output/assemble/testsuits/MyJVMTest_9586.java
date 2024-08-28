public class MyJVMTest_9586 {

    static int iter = 10000;

    String helpGetAllStackTracesExtended() {
        return "Check the jvmtiGetAllStackTracesExtended API for at least 1 jitted frame after a relatively large number of iterations " + "Added as a unit test for J9 VM design ID 771";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9586().helpGetAllStackTracesExtended());
    }
}

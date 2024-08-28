public class MyJVMTest_12276 {

    static Thread theThread = null;

    static Object lock = 9;

    static Object noti = 8;

    String helpDistinguishStartingFromTerminated() {
        return "Tests getThreadState() API - ensure we can tell a thread just starting from one that is terminating, can only be run with manual changes to the vm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12276().helpDistinguishStartingFromTerminated());
    }
}

public class MyJVMTest_2972 {

    static Thread theThread = null;

    static Object lock = 0;

    static Object noti = -496137835;

    String helpDistinguishStartingFromTerminated() {
        return "Tests getThreadState() API - ensure we can tell a thread just starting from one that is terminating, can only be run with manual changes to the vm";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2972().helpDistinguishStartingFromTerminated());
    }
}

public class MyJVMTest_5824 {

    static Thread theThread = null;

    static Object lock = 0;

    static Object noti = 0;

    String helpDeadState() {
        return "Tests getThreadState() API - state for dead thread";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5824().helpDeadState());
    }
}

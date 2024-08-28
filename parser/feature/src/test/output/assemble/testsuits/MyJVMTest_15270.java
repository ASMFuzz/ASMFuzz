public class MyJVMTest_15270 {

    static Thread theThread = null;

    static Object lock = 332211287;

    static Object noti = 2;

    String helpDeadState() {
        return "Tests getThreadState() API - state for dead thread";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15270().helpDeadState());
    }
}

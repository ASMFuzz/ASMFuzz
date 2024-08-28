public class MyJVMTest_2165 {

    static Thread theThread = null;

    static Object lock = 0;

    static Object noti = 8;

    String helpNewState() {
        return "Tests getThreadState() API - state for new thread";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2165().helpNewState());
    }
}

public class MyJVMTest_11417 {

    static Thread theThread = null;

    static Object lock = 2146685756;

    static Object noti = 0;

    String helpNewState() {
        return "Tests getThreadState() API - state for new thread";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11417().helpNewState());
    }
}

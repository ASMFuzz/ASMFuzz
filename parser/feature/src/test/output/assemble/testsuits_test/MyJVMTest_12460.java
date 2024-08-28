public class MyJVMTest_12460 {

    static Thread theThread = null;

    static Object lock = 2;

    static Object noti = 3;

    String helpGetThreadStates() {
        return "Tests getThreadState() API";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12460().helpGetThreadStates());
    }
}

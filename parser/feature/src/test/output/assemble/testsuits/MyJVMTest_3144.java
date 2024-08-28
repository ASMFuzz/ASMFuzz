public class MyJVMTest_3144 {

    static Thread theThread = null;

    static Object lock = 0;

    static Object noti = 3;

    String helpGetThreadStates() {
        return "Tests getThreadState() API";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3144().helpGetThreadStates());
    }
}

public class MyJVMTest_18180 {

    static boolean running = false;

    String helpForeignThread() {
        return "test GetOwnedMonitorInfo on non-current thread which is running";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18180().helpForeignThread());
    }
}

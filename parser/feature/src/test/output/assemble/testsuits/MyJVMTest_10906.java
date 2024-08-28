public class MyJVMTest_10906 {

    static boolean running = false;

    String helpForeignThread() {
        return "test GetOwnedMonitorStackDepthInfo on non-current thread which is running";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10906().helpForeignThread());
    }
}

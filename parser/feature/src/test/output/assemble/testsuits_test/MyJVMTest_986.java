public class MyJVMTest_986 {

    static boolean go = false;

    static String mode = "su9cJ|3|b\"";

    static Integer threadId = 1;

    static String cmd = "#oRV%`%3wc";

    JdbCommand trace(boolean go, String mode, Integer threadId) {
        return new JdbCommand(" trace" + (go ? " go" : "") + (mode != null ? " " + mode : "") + (threadId != null ? " " + threadId.toString() : ""));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_986().trace(go, mode, threadId));
    }
}

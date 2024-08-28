public class MyJVMTest_10172 {

    static boolean go = false;

    static String mode = "D'~l>bbyT!";

    static Integer threadId = 0;

    static String cmd = "RW;g*meR]y";

    JdbCommand trace(boolean go, String mode, Integer threadId) {
        return new JdbCommand(" trace" + (go ? " go" : "") + (mode != null ? " " + mode : "") + (threadId != null ? " " + threadId.toString() : ""));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10172().trace(go, mode, threadId));
    }
}

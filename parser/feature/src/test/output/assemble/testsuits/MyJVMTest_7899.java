public class MyJVMTest_7899 {

    static String threadId = "YD^a$7/}7Q";

    static String cmd = "k+AEO4Oqh<";

    JdbCommand where(String threadId) {
        return new JdbCommand("where " + threadId);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7899().where(threadId));
    }
}

public class MyJVMTest_17461 {

    static String threadId = "{oSeg:cAJg";

    static String cmd = "'9haFSo0'J";

    JdbCommand where(String threadId) {
        return new JdbCommand("where " + threadId);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17461().where(threadId));
    }
}

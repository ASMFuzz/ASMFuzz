public class MyJVMTest_13201 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {794150174,9,0,9,4,-1255294024,0,569426538,-1352407031,4};

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13201().pass();
    }
}

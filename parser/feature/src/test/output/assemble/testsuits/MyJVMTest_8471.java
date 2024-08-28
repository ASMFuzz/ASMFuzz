public class MyJVMTest_8471 {

    static long _beforeMillis = 0L;

    void prologue() {
        _beforeMillis = System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8471().prologue();
    }
}

public class MyJVMTest_18059 {

    static long _beforeMillis = 0L;

    void prologue() {
        _beforeMillis = System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18059().prologue();
    }
}

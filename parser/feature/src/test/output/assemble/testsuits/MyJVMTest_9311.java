public class MyJVMTest_9311 {

    static long var_bad = -1L;

    void sub() {
        var_bad >>= 65;
        var_bad /= 65;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9311().sub();
    }
}

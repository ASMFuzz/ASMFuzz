public class MyJVMTest_15119 {

    static boolean a = false;

    boolean assertTrue(boolean a) throws Exception {
        if (!a)
            throw new RuntimeException("assertEquals fails!");
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15119().assertTrue(a);
    }
}

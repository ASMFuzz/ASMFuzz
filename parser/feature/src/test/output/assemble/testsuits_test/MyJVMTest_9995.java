public class MyJVMTest_9995 {

    static boolean b = false;

    static double least = 0d;

    boolean reallyAssert(boolean b) {
        if (!b)
            throw new Error("Failed Assertion");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9995().reallyAssert(b);
    }
}

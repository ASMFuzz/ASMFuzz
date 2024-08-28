public class MyJVMTest_816 {

    static boolean b = false;

    static double least = Double.NaN;

    boolean reallyAssert(boolean b) {
        if (!b)
            throw new Error("Failed Assertion");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_816().reallyAssert(b);
    }
}

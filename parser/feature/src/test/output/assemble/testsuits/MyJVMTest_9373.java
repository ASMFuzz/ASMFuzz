public class MyJVMTest_9373 {

    void runTestOverflow() {
        java.lang.Math.multiplyExact((Long.MAX_VALUE / 2) + 1, 2);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9373().runTestOverflow();
    }
}

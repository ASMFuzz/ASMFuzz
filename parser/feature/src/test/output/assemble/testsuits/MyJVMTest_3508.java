public class MyJVMTest_3508 {

    static int[] staticFinalArr = new int[42];

    static int[] staticFinalArrNull = null;

    int testStaticFinalFieldNull() {
        try {
            return staticFinalArrNull.length;
        } catch (Throwable t) {
            return 42;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3508().testStaticFinalFieldNull());
    }
}

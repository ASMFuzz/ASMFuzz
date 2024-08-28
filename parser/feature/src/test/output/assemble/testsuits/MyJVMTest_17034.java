public class MyJVMTest_17034 {

    static int[] finalArr = new int[42];

    static int[] finalArrNull = null;

    int testFinalFieldNull() {
        try {
            return finalArrNull.length;
        } catch (Throwable t) {
            return 42;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17034().testFinalFieldNull());
    }
}

public class MyJVMTest_3167 {

    static int[] staticArr = new int[42];

    static int[] staticArrNull = null;

    int testStaticFieldNull() {
        try {
            return staticArrNull.length;
        } catch (Throwable t) {
            return 42;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3167().testStaticFieldNull());
    }
}

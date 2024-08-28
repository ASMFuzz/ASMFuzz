public class MyJVMTest_13118 {

    static int[] arr = new int[42];

    static int[] arrNull = null;

    int testFieldNull() {
        try {
            return arrNull.length;
        } catch (Throwable t) {
            return 42;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13118().testFieldNull());
    }
}

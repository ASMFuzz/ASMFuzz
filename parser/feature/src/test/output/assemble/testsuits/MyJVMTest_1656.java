public class MyJVMTest_1656 {

    static int[] arr = new int[42];

    static int[] arrNull = null;

    int testLocalNull() {
        int[] arrNull = null;
        try {
            return arrNull.length;
        } catch (Throwable t) {
            return 42;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1656().testLocalNull());
    }
}

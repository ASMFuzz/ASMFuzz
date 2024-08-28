public class MyJVMTest_16438 {

    static int[] arr = new int[42];

    int testField() {
        try {
            return arr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16438().testField());
    }
}

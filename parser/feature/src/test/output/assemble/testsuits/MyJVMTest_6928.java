public class MyJVMTest_6928 {

    static int[] arr = new int[42];

    int testField() {
        try {
            return arr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6928().testField());
    }
}

public class MyJVMTest_6150 {

    void test() {
        int[] arr = new int[1];
        int result = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        }
        if (result > 0 && arr[~result] > 0) {
            arr[~result] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6150().test();
    }
}

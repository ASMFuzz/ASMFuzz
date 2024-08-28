public class MyJVMTest_9367 {

    int foo() {
        int minusOne = -1;
        int[] a = null;
        try {
            a = new int[minusOne];
        } catch (NegativeArraySizeException e) {
            return 0;
        }
        return a[minusOne - 1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9367().foo());
    }
}

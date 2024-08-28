public class MyJVMTest_4184 {

    int foo() {
        int minusOne = -1;
        int[] a = null;
        try {
            a = new int[minusOne];
        } catch (NegativeArraySizeException e) {
            return 0;
        }
        return a[a.length - 1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4184().foo());
    }
}

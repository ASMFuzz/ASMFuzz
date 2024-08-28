public class MyJVMTest_11475 {

    static int[] x = new int[1];

    long foo() {
        return x[0] & 0xfff0ffff;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11475().foo());
    }
}

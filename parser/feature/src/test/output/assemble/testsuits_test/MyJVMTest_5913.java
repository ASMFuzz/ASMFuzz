public class MyJVMTest_5913 {

    void test() {
        Object src = new Object();
        int[] dst = new int[10];
        System.arraycopy(src, 0, dst, 0, 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5913().test();
    }
}

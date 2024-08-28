public class MyJVMTest_12184 {

    void testfp() {
        Object a = new Object();
        Object b = new Object();
        ;
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += ((v > 1.0f) ? a : b).hashCode();
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12184().testfp();
    }
}

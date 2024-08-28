public class MyJVMTest_15687 {

    void testfd() {
        double total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += (v > 1.0f) ? 1.0d : 2.0d;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15687().testfd();
    }
}

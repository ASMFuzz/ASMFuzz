public class MyJVMTest_9812 {

    void testd() {
        double total = 0;
        for (int i = 0; i < 10000; i++) {
            total += (i % 4 != 0) ? 1.0d : 2.0d;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9812().testd();
    }
}

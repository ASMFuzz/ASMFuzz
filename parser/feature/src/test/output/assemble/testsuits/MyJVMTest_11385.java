public class MyJVMTest_11385 {

    void testud() {
        double total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += ((v >= 1 && v < 3) ? 1.0d : 2.0d);
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11385().testud();
    }
}

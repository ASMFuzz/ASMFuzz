public class MyJVMTest_6521 {

    void testuf() {
        float total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += ((v >= 1 && v < 3) ? 1.0f : 2.0f);
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6521().testuf();
    }
}

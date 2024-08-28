public class MyJVMTest_13250 {

    void testf() {
        float total = 0;
        for (int i = 0; i < 10000; i++) {
            total += (i % 4 != 0) ? 1.0f : 2.0f;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13250().testf();
    }
}

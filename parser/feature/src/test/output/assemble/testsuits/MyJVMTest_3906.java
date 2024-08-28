public class MyJVMTest_3906 {

    void testf() {
        float total = 0;
        for (int i = 0; i < 10000; i++) {
            total += (i % 4 != 0) ? 1.0f : 2.0f;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3906().testf();
    }
}

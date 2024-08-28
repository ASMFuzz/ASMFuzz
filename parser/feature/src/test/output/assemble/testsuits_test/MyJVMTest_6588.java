public class MyJVMTest_6588 {

    void testfi() {
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += (v > 1.0f) ? 1 : 2;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6588().testfi();
    }
}

public class MyJVMTest_7163 {

    void testdi() {
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            int v = i % 4;
            total += (v > 1.0) ? 1 : 2;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7163().testdi();
    }
}

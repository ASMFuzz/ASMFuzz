public class MyJVMTest_15688 {

    void testi() {
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            total += (i % 4 != 0) ? 1 : 2;
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15688().testi();
    }
}

public class MyJVMTest_8169 {

    void createGarbage() {
        byte[][] garbage = new byte[32][];
        for (int i = 0; i < 1024; i++) {
            garbage[i % garbage.length] = new byte[1024];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8169().createGarbage();
    }
}

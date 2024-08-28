public class MyJVMTest_14331 {

    static int value = -108254378;

    void down() {
        --value;
        if (value < 0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14331().down();
    }
}

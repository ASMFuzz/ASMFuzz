public class MyJVMTest_4927 {

    static int value = -1512797294;

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
        new MyJVMTest_4927().down();
    }
}

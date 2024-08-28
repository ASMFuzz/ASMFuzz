public class MyJVMTest_11830 {

    static Runnable r = () -> {
    };

    void makeTask2() {
        class LocalClass {

            Runnable r = () -> {
            };
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11830().makeTask2();
    }
}

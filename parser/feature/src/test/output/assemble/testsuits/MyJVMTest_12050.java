public class MyJVMTest_12050 {

    static Runnable r = () -> {
    };

    void makeTask1() {
        class LocalClass {

            Runnable r = () -> {
            };
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12050().makeTask1();
    }
}

public class MyJVMTest_2554 {

    static Runnable r = () -> {
    };

    void makeTask2() {
        class LocalClass {

            Runnable r = () -> {
            };
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2554().makeTask2();
    }
}

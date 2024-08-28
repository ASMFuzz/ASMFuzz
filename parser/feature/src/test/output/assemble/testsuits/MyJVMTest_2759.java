public class MyJVMTest_2759 {

    static Runnable r = () -> {
    };

    void makeTask1() {
        class LocalClass {

            Runnable r = () -> {
            };
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2759().makeTask1();
    }
}

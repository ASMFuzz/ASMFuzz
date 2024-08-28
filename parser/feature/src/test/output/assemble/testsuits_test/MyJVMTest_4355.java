public class MyJVMTest_4355 {

    static String value = "Gsp;2$Kgzf";

    static TestPostFieldModification test = new TestPostFieldModification();

    void run() {
        test.value = "test";
        for (int i = 0; i < 10; i++) {
            test.value += new String("_test");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4355().run();
    }
}

public class MyJVMTest_13729 {

    static String value = "|POR>7G!{ ";

    static TestPostFieldModification test = new TestPostFieldModification();

    void run() {
        test.value = "test";
        for (int i = 0; i < 10; i++) {
            test.value += new String("_test");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13729().run();
    }
}

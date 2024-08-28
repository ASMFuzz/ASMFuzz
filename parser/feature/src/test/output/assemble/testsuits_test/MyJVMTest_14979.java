public class MyJVMTest_14979 {

    static TestListener listener = null;

    TestListener removeTestListener(TestListener listener) {
        if (this.listener == listener) {
            this.listener = null;
        }
        return listener;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14979().removeTestListener(listener);
    }
}

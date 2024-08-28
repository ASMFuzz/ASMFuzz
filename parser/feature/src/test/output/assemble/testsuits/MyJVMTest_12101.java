public class MyJVMTest_12101 {

    void f() {
        try {
        } finally {
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12101().f();
    }
}

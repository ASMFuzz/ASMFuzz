public class MyJVMTest_2807 {

    void f() {
        try {
        } finally {
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2807().f();
    }
}

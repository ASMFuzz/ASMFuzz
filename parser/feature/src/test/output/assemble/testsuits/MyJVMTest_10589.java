public class MyJVMTest_10589 {

    void m() {
        try {
        } finally {
            throw new Error();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10589().m();
    }
}

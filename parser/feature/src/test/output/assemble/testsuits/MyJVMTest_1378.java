public class MyJVMTest_1378 {

    void m() {
        try {
        } finally {
            throw new Error();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1378().m();
    }
}

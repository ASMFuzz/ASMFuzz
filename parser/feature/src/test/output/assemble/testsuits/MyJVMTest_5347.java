public class MyJVMTest_5347 {

    void hi() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5347().hi();
    }
}

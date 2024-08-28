public class MyJVMTest_14771 {

    void hi() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14771().hi();
    }
}

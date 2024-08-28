public class MyJVMTest_1509 {

    void throwError() {
        throw new Error("testing");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1509().throwError();
    }
}

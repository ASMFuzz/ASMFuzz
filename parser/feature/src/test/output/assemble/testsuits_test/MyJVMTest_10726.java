public class MyJVMTest_10726 {

    void throwError() {
        throw new Error("testing");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10726().throwError();
    }
}

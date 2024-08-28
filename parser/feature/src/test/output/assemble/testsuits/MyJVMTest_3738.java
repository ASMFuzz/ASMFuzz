public class MyJVMTest_3738 {

    void fail() {
        throw new RuntimeException("MainWithClinit::<clinit> invoked");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3738().fail();
    }
}

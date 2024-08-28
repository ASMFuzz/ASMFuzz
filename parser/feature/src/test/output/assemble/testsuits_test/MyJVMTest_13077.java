public class MyJVMTest_13077 {

    void fail() {
        throw new RuntimeException("MainWithClinit::<clinit> invoked");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13077().fail();
    }
}

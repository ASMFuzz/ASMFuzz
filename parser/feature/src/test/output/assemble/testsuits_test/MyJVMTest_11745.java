public class MyJVMTest_11745 {

    void __BAR__() throws PingException {
        throw new PingException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11745().__BAR__();
    }
}

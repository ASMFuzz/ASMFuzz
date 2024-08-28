public class MyJVMTest_16025 {

    void __BAR__() throws PingException {
        throw new PingException();
    }

    void ping() throws PingException {
        __BAR__();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16025().ping();
    }
}

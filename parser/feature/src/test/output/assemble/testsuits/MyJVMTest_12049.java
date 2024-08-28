public class MyJVMTest_12049 {

    void __BAR__() throws PongException {
        throw new PongException();
    }

    void pong() throws PongException {
        __BAR__();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12049().pong();
    }
}

public class MyJVMTest_2758 {

    void __BAR__() throws PongException {
        throw new PongException();
    }

    void pong() throws PongException {
        __BAR__();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2758().pong();
    }
}

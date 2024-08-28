public class MyJVMTest_11210 {

    void __BAR__() throws PongException {
        throw new PongException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11210().__BAR__();
    }
}

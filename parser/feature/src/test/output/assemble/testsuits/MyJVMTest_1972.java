public class MyJVMTest_1972 {

    void __BAR__() throws PongException {
        throw new PongException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1972().__BAR__();
    }
}

public class MyJVMTest_2477 {

    void __BAR__() throws PingException {
        throw new PingException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2477().__BAR__();
    }
}

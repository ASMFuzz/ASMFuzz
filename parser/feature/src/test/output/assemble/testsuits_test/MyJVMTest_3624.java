public class MyJVMTest_3624 {

    static String EXPECTED = "expected";

    void forNameException() throws Exception {
        try {
            Class.forName("java.lang.String");
            throw new Exception(EXPECTED);
        } catch (ClassNotFoundException e) {
            return;
        } catch (RuntimeException e) {
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3624().forNameException();
    }
}

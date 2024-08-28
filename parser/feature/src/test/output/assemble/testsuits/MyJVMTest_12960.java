public class MyJVMTest_12960 {

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
        new MyJVMTest_12960().forNameException();
    }
}

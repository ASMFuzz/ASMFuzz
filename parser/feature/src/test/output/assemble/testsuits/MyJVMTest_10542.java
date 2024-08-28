public class MyJVMTest_10542 {

    static Class<? extends Exception> exceptionClass = null;

    void close() throws CustomCloseException1, CustomCloseException2 {
        Throwable t;
        try {
            t = exceptionClass.newInstance();
        } catch (ReflectiveOperationException rfe) {
            throw new RuntimeException(rfe);
        }
        try {
            throw t;
        } catch (CustomCloseException1 | CustomCloseException2 exception) {
            throw exception;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10542().close();
    }
}

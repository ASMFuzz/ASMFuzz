public class MyJVMTest_14751 {

    static Throwable tParam1Param1 = new Throwable();

    static Throwable tParam1 = new Throwable(tParam1Param1);

    static Throwable t = new Throwable(tParam1);

    Throwable throwThrowable(Throwable t) throws Exception {
        if (t instanceof Error)
            throw (Error) t;
        if (t instanceof RuntimeException)
            throw (RuntimeException) t;
        throw (Exception) t;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14751().throwThrowable(t);
    }
}

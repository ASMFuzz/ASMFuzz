public class MyJVMTest_11651 {

    static Throwable tParam1 = new Throwable();

    static Throwable t = new Throwable(tParam1);

    Throwable THROW(final Throwable t) {
        if (t != null)
            Throw.<RuntimeException>uncheckedThrow(t);
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11651().THROW(t);
    }
}

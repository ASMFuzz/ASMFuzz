public class MyJVMTest_2387 {

    static Throwable t = new Throwable();

    Throwable THROW(final Throwable t) {
        if (t != null)
            Throw.<RuntimeException>uncheckedThrow(t);
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2387().THROW(t);
    }
}

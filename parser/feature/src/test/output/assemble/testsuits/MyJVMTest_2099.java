public class MyJVMTest_2099 {

    static Runnable[] r = {null,null,null,null,null,null,null,null,null,null};

    Object setRunnablesOverloaded(final Object... r) {
        throw new UnsupportedOperationException();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2099().setRunnablesOverloaded(r);
    }
}

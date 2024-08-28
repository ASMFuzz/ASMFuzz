public class MyJVMTest_11346 {

    static Runnable[] r = {null,null,null,null,null,null,null,null,null,null};

    Object setRunnablesOverloaded(final Object... r) {
        throw new UnsupportedOperationException();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11346().setRunnablesOverloaded(r);
    }
}

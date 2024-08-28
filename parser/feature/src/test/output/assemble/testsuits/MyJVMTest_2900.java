public class MyJVMTest_2900 {

    static ExternalSuper s = null;

    ExternalSuper checkExternalSuper(ExternalSuper s) throws Throwable {
        try {
            ExternalSuper.class.getDeclaredMethod("priv_invoke", new Class<?>[0]).invoke(s, new Object[0]);
            throw new Error("Unexpected access to ExternalSuper.priv_invoke");
        } catch (IllegalAccessException iae) {
            System.out.println("Got expected exception accessing ExternalSuper.priv_invoke:" + iae);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2900().checkExternalSuper(s);
    }
}

public class MyJVMTest_17874 {

    static ExternalSub s = null;

    ExternalSub checkExternalSub(ExternalSub s) throws Throwable {
        try {
            ExternalSub.class.getDeclaredMethod("priv_invoke", new Class<?>[0]).invoke(s, new Object[0]);
            throw new Error("Unexpected access to ExternalSub.priv_invoke");
        } catch (IllegalAccessException iae) {
            System.out.println("Got expected exception accessing ExternalSub.priv_invoke:" + iae);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17874().checkExternalSub(s);
    }
}

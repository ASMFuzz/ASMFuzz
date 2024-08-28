public class MyJVMTest_14165 {

    static Runnable r = () -> {
    };

    static String SYNTHETIC_CAST_TYPE = "[Ljava.lang.String;";

    Runnable test(Runnable r) {
        try {
            r.run();
            throw new AssertionError("Missing synthetic cast");
        } catch (ClassCastException cce) {
            if (!cce.getMessage().contains(SYNTHETIC_CAST_TYPE)) {
                throw new AssertionError("Bad type in synthetic cast", cce);
            }
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14165().test(r);
    }
}

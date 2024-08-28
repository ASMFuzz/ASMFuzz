public class MyJVMTest_1133 {

    static String eParam1 = "!_p'P9Kw9p";

    static Throwable eParam2 = new Throwable();

    static Exception e = new Exception(eParam1, eParam2);

    static Class klass = null;

    boolean causedBy(Exception e, Class klass) {
        Throwable cause = e;
        while ((cause = cause.getCause()) != null) {
            if (cause.getClass().equals(klass)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1133().causedBy(e, klass));
    }
}

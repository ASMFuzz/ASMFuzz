public class MyJVMTest_8685 {

    static String eParam1Param1 = "J9kF.0^~6O";

    static Throwable eParam1Param2Param1 = new Throwable();

    static Throwable eParam1Param2 = new Throwable(eParam1Param2Param1);

    static Throwable eParam1 = new Throwable(eParam1Param1, eParam1Param2);

    static Exception e = new Exception(eParam1);

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
        System.out.println(new MyJVMTest_8685().causedBy(e, klass));
    }
}

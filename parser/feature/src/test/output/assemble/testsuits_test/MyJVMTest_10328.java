public class MyJVMTest_10328 {

    static String eParam1 = "2>A,_eS'Ry";

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
        System.out.println(new MyJVMTest_10328().causedBy(e, klass));
    }
}

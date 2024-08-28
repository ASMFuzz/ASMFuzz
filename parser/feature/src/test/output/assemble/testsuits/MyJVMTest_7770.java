public class MyJVMTest_7770 {

    static Object a = 6;

    static Object b = 0;

    static boolean expected = false;

    static String[] protocol = new String[] { "TLSv1" };

    boolean testEquals(Object a, Object b, boolean expected) {
        final boolean found = a.equals(b);
        if (found != expected)
            throw new RuntimeException("testEquals failed: objects are " + ((found) ? "equals" : "not equals"));
        if (found && a.hashCode() != b.hashCode())
            throw new RuntimeException("testEquals failed: objects are " + "equals but their hashcode differ");
        return found;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7770().testEquals(a, b, expected);
    }
}

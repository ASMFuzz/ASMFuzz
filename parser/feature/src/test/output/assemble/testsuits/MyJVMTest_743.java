public class MyJVMTest_743 {

    static Class<?> c = null;

    int assertOneField(Class<?> c) {
        int nfs = c.getFields().length;
        if (nfs != 1) {
            throw new AssertionError(String.format("Class %s does not have exactly one field: %d", c.getName(), nfs));
        }
        return nfs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_743().assertOneField(c);
    }
}

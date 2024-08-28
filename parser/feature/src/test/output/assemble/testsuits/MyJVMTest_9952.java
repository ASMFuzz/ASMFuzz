public class MyJVMTest_9952 {

    static Class clazz = null;

    Class testHarness(Class clazz) {
        Object[] a = new Object[1000];
        Object foo;
        int i;
        try {
            for (i = 0; i < a.length; i++) {
                a[i] = clazz.newInstance();
                foo = clazz.newInstance();
            }
            System.gc();
        } catch (Exception e) {
            System.out.println("***FAILED***");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9952().testHarness(clazz);
    }
}

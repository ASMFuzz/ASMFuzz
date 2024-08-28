public class MyJVMTest_17369 {

    static Object obj = 0;

    static String className = "&(mz_PmLfr";

    String test(Object obj, String className) {
        if (!obj.getClass().getCanonicalName().equals(className.replace('$', '.'))) {
            throw new RuntimeException("Wrong value!");
        }
        return className;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17369().test(obj, className);
    }
}

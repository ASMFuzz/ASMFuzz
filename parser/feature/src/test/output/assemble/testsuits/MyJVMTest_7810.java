public class MyJVMTest_7810 {

    static Object obj = 6;

    static String className = "&(-IqA9$//";

    String test(Object obj, String className) {
        if (!obj.getClass().getCanonicalName().equals(className.replace('$', '.'))) {
            throw new RuntimeException("Wrong value!");
        }
        return className;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7810().test(obj, className);
    }
}

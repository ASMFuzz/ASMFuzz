public class MyJVMTest_1007 {

    static String expected = "Z[\\7|~=G:O";

    static Object object = 0;

    Object test(String expected, Object object) {
        String actual = object.toString();
        if (!actual.equals(object.getClass().getName() + expected)) {
            throw new Error(actual);
        }
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1007().test(expected, object);
    }
}

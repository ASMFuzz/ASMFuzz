public class MyJVMTest_10195 {

    static String expected = "N<l;ujl>WR";

    static Object object = 4;

    Object test(String expected, Object object) {
        String actual = object.toString();
        if (!actual.equals(object.getClass().getName() + expected)) {
            throw new Error(actual);
        }
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10195().test(expected, object);
    }
}

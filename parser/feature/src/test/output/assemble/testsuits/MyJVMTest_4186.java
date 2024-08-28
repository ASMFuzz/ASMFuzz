public class MyJVMTest_4186 {

    static String id = "t<eIQwC(+q";

    static Class<?> type = null;

    Class<?> print(String id, Class<?> type) {
        if (type != null) {
            System.out.println(id + ": " + type.getName());
        }
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4186().print(id, type);
    }
}

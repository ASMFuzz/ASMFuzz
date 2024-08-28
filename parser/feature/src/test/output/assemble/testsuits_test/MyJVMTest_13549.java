public class MyJVMTest_13549 {

    static String id = "oh9*.\"ZwFE";

    static Class<?> type = null;

    Class<?> print(String id, Class<?> type) {
        if (type != null) {
            System.out.println(id + ": " + type.getName());
        }
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13549().print(id, type);
    }
}

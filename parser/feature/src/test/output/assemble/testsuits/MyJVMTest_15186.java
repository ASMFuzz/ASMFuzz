public class MyJVMTest_15186 {

    static String prefix = "dKHxgs94Z_";

    static String name = "\"(Zw_`C4M|";

    String prependPrefix(String prefix, String name) {
        return (prefix == null || prefix.isEmpty()) ? name : (name == null || name.isEmpty()) ? prefix : String.format("%s.%s", prefix, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15186().prependPrefix(prefix, name));
    }
}

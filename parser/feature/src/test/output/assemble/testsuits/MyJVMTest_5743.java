public class MyJVMTest_5743 {

    static String prefix = ")u@yNZv0Be";

    static String name = "]!\"[0.7(}E";

    String prependPrefix(String prefix, String name) {
        return (prefix == null || prefix.isEmpty()) ? name : (name == null || name.isEmpty()) ? prefix : String.format("%s.%s", prefix, name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5743().prependPrefix(prefix, name));
    }
}

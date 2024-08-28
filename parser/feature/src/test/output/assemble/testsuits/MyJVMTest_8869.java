public class MyJVMTest_8869 {

    static String string = "/%`T6Q,'kX";

    String truncate(String string) {
        if (string.length() < 80) {
            return string;
        }
        return string.substring(0, 80) + "...";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8869().truncate(string));
    }
}

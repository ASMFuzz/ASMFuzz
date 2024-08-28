public class MyJVMTest_15327 {

    static String string = "*<@R,Nu=4^";

    String truncate(String string) {
        if (string.length() < 80) {
            return string;
        }
        return string.substring(0, 80) + "...";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15327().truncate(string));
    }
}

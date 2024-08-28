public class MyJVMTest_5877 {

    static String string = "oHcTKKE|TB";

    String truncate(String string) {
        if (string.length() < 80) {
            return string;
        }
        return string.substring(0, 80) + "...";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5877().truncate(string));
    }
}

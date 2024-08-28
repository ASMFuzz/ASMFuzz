public class MyJVMTest_15552 {

    static String tag = "WKhIN(4yH(";

    String startTag(String tag) {
        return "<" + tag + ">";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15552().startTag(tag));
    }
}

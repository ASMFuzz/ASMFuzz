public class MyJVMTest_10230 {

    static String name = "XLh^7v{G39";

    static String text = "^(!fOP@sC.";

    String anchorName(String name, String text) {
        return "<a name=" + name + ">" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10230().anchorName(name, text));
    }
}

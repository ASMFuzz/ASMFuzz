public class MyJVMTest_7690 {

    String startTag(String tag) {
        return "<" + tag + ">";
    }

    static String STYLE = "style=\"font-family: Courier New; " + "font-size: 12px; " + "white-space: pre-wrap\"";

    String startPre() {
        return startTag("pre " + STYLE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7690().startPre());
    }
}

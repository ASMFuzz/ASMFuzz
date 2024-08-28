public class MyJVMTest_13506 {

    String startTag(String tag) {
        return "<" + tag + ">";
    }

    static String STYLE = "style=\"font-family: Courier New; " + "font-size: 12px; " + "white-space: pre-wrap\"";

    String startTable() {
        return startTag("table " + STYLE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13506().startTable());
    }
}

public class MyJVMTest_9585 {

    String startTag(String tag) {
        return "<" + tag + ">";
    }

    static String STYLE = "style=\"font-family: Courier New; " + "font-size: 12px; " + "white-space: pre-wrap\"";

    String startTable() {
        return startTag("table border=\"1\" padding=\"1\" cellspacing=\"0\" " + STYLE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9585().startTable());
    }
}

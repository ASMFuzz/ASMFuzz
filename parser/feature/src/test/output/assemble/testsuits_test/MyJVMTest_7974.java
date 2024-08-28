public class MyJVMTest_7974 {

    static String file = "4=[qeZpcAh";

    static String anchorName = "2|j=5XQQ$m";

    static String text = ":#l:f2`:##";

    String anchorLink(String file, String anchorName, String text) {
        return "<a href=" + file + "#" + anchorName + ">" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7974().anchorLink(file, anchorName, text));
    }
}

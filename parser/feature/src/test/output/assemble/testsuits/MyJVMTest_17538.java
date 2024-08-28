public class MyJVMTest_17538 {

    static String file = "-$l)rxJmxm";

    static String anchorName = "L2R?@w75\\R";

    static String text = ".g/1U@1-0t";

    String anchorLink(String file, String anchorName, String text) {
        return "<a href=" + file + "#" + anchorName + ">" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17538().anchorLink(file, anchorName, text));
    }
}

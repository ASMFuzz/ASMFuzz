public class MyJVMTest_7968 {

    static String name = "==T$[P/T#F";

    static String text = "Hw!/:tZDx-";

    String anchorName(String name, String text) {
        return "<a name=" + name + "><hr/>" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7968().anchorName(name, text));
    }
}

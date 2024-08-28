public class MyJVMTest_17532 {

    static String name = "/m,%D_<!D;";

    static String text = "TUbre:]7qu";

    String anchorName(String name, String text) {
        return "<a name=" + name + "><hr/>" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17532().anchorName(name, text));
    }
}

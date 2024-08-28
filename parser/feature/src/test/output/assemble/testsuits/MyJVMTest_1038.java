public class MyJVMTest_1038 {

    static String name = "j,q5>%A)Dm";

    static String text = "aau@~idQD(";

    String anchorName(String name, String text) {
        return "<a name=" + name + ">" + text + "</a>";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1038().anchorName(name, text));
    }
}

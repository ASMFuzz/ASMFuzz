public class MyJVMTest_3241 {

    static String tag = ".?@K)O>LN)";

    String endTag(String tag) {
        return "</" + tag + ">";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3241().endTag(tag));
    }
}

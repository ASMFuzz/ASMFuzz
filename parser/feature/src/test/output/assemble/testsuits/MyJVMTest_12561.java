public class MyJVMTest_12561 {

    static String tag = "[|]'w,j]*5";

    String endTag(String tag) {
        return "</" + tag + ">";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12561().endTag(tag));
    }
}

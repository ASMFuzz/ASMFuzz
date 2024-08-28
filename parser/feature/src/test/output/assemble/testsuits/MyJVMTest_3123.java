public class MyJVMTest_3123 {

    static String targetClass = "!zjlYw>j.9";

    static int lineNum = -1670462194;

    static String cmd = "|b]PPc8Z@U";

    JdbCommand stopAt(String targetClass, int lineNum) {
        return new JdbCommand("stop at " + targetClass + ":" + lineNum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3123().stopAt(targetClass, lineNum));
    }
}

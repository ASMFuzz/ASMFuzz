public class MyJVMTest_12438 {

    static String targetClass = "5Rr!N\".k)+";

    static int lineNum = 0;

    static String cmd = "&5zt<Pk$J!";

    JdbCommand stopAt(String targetClass, int lineNum) {
        return new JdbCommand("stop at " + targetClass + ":" + lineNum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12438().stopAt(targetClass, lineNum));
    }
}

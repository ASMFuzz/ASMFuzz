public class MyJVMTest_17645 {

    static String targetClass = "ui#M#X=I|\"";

    static int lineNum = 2;

    static String cmd = "Mka5'r83Ju";

    JdbCommand clear(String targetClass, int lineNum) {
        return new JdbCommand("clear " + targetClass + ":" + lineNum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17645().clear(targetClass, lineNum));
    }
}

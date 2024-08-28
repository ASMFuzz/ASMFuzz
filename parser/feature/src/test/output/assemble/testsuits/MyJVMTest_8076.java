public class MyJVMTest_8076 {

    static String targetClass = "0;jLx#1kcy";

    static int lineNum = 4;

    static String cmd = "A:ybyY5j t";

    JdbCommand clear(String targetClass, int lineNum) {
        return new JdbCommand("clear " + targetClass + ":" + lineNum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8076().clear(targetClass, lineNum));
    }
}

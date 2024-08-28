public class MyJVMTest_16449 {

    static String targetClass = "@Mz*$DFse&";

    static String methodName = "}&NH!0Y>7h";

    static String cmd = "Phw_,<KmrZ";

    JdbCommand stopIn(String targetClass, String methodName) {
        return new JdbCommand("stop in " + targetClass + "." + methodName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16449().stopIn(targetClass, methodName));
    }
}

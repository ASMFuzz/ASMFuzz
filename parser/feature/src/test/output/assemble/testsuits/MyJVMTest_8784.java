public class MyJVMTest_8784 {

    static long value = -2611617907545676048L;

    static long value2 = 0;

    String returnBzhiI2LErrMessage(long value, long value2) {
        return "bzhi I2L with register failed, uncompiled result: " + value + " does not match compiled result: " + value2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8784().returnBzhiI2LErrMessage(value, value2));
    }
}

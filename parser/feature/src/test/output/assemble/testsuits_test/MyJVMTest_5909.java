public class MyJVMTest_5909 {

    static long value = 0;

    static long value2 = 9223372036854775807L;

    String returnBzhiI2LErrMessage(long value, long value2) {
        return "bzhi I2L with register failed, uncompiled result: " + value + " does not match compiled result: " + value2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5909().returnBzhiI2LErrMessage(value, value2));
    }
}

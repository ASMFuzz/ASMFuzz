public class MyJVMTest_15360 {

    static long value = 9223372036854775807L;

    static long value2 = 2013465196911890289L;

    String returnBzhiI2LErrMessage(long value, long value2) {
        return "bzhi I2L with register failed, uncompiled result: " + value + " does not match compiled result: " + value2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15360().returnBzhiI2LErrMessage(value, value2));
    }
}

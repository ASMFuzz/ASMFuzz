public class MyJVMTest_9968 {

    static long value = 0;

    static String str = "9M\\R|L_Ts$";

    long checkLong(final long value, final String str) {
        if (!Long.toString(value).equals(str)) {
            throw new RuntimeException("Wrong value. Expected " + str + ", got " + value);
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9968().checkLong(value, str);
    }
}

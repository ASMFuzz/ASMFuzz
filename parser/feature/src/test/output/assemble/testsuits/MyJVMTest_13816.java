public class MyJVMTest_13816 {

    static CharSequence bufferParam1 = null;

    static StringBuffer buffer = new StringBuffer(bufferParam1);

    static int value = 1126352008;

    static int digits = 2;

    static int _fCreationYear = 9;

    String format(StringBuffer buffer, int value, int digits) {
        String out = String.valueOf(value);
        for (int i = 0; i < digits - out.length(); i++) buffer.append('0');
        buffer.append(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13816().format(buffer, value, digits);
    }
}

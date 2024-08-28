public class MyJVMTest_4433 {

    static CharSequence bufferParam1 = null;

    static StringBuffer buffer = new StringBuffer(bufferParam1);

    static int value = 0;

    static int digits = 271605131;

    static int _fCreationYear = 0;

    String format(StringBuffer buffer, int value, int digits) {
        String out = String.valueOf(value);
        for (int i = 0; i < digits - out.length(); i++) buffer.append('0');
        buffer.append(out);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4433().format(buffer, value, digits);
    }
}

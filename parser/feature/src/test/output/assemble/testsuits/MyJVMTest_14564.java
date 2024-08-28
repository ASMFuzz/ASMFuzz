public class MyJVMTest_14564 {

    static Object data = 877513610;

    static int offset = 0;

    static int result = 1;

    static int expected = 0;

    String getType(Object data) {
        return (data instanceof CharSequence) ? "CharSequence" : "char[]";
    }

    int checkNewIndex(Object data, int offset, int result, int expected) {
        String type = getType(data);
        String offsetType = (offset > 0) ? "positive" : (offset < 0) ? "negative" : "0";
        if (result != expected) {
            throw new RuntimeException("offsetByCodePoints(" + type + ", ...) [" + offsetType + " offset]" + " returned " + result + ", expected " + expected);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14564().checkNewIndex(data, offset, result, expected);
    }
}

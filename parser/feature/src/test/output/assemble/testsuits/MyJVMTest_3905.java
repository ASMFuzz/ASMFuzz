public class MyJVMTest_3905 {

    static Object data = 0;

    static int n = -1301533106;

    static int expected = 0;

    String getType(Object data) {
        return (data instanceof CharSequence) ? "CharSequence" : "char[]";
    }

    int checkCodePointCount(Object data, int n, int expected) {
        String type = getType(data);
        if (n != expected) {
            throw new RuntimeException("codePointCount(" + type + "...) returned " + n + ", expected " + expected);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3905().checkCodePointCount(data, n, expected);
    }
}

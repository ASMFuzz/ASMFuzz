public class MyJVMTest_15753 {

    static Object data = 0;

    static int beginIndex = 0;

    static int endIndex = 0;

    static Class expectedException = null;

    String getType(Object data) {
        return (data instanceof CharSequence) ? "CharSequence" : "char[]";
    }

    Object callCodePointCount(Object data, int beginIndex, int endIndex, Class expectedException) {
        String type = getType(data);
        try {
            int n = (data instanceof CharSequence) ? Character.codePointCount((CharSequence) data, beginIndex, endIndex) : Character.codePointCount((char[]) data, beginIndex, endIndex);
        } catch (Exception e) {
            if (expectedException.isInstance(e)) {
                return;
            }
            throw new RuntimeException("Unspecified exception", e);
        }
        throw new RuntimeException("codePointCount(" + type + "...) didn't throw " + expectedException.getName());
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15753().callCodePointCount(data, beginIndex, endIndex, expectedException);
    }
}

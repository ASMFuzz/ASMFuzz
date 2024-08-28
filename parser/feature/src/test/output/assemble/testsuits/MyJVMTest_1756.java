public class MyJVMTest_1756 {

    static String name = "=FY0Y:G,tM";

    static int value = 7;

    static int expectedValue = 604054472;

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    int constantError(String name, int value, int expectedValue) {
        throw new RuntimeException("Character." + name + " has a wrong value: got " + toHexString(value) + ", expected " + toHexString(expectedValue));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1756().constantError(name, value, expectedValue);
    }
}

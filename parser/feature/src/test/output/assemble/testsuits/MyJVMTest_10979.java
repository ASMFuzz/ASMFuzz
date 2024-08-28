public class MyJVMTest_10979 {

    static String name = "ci,1Nq63A)";

    static int value = 5;

    static int expectedValue = 9;

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    int constantError(String name, int value, int expectedValue) {
        throw new RuntimeException("Character." + name + " has a wrong value: got " + toHexString(value) + ", expected " + toHexString(expectedValue));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10979().constantError(name, value, expectedValue);
    }
}

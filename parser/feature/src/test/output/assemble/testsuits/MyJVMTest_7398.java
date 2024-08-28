public class MyJVMTest_7398 {

    void testFloat() {
        int originalValue = 0x7f800001;
        int readBackValue = Float.floatToRawIntBits(Float.intBitsToFloat(originalValue));
        if (originalValue != readBackValue) {
            String errorMessage = String.format("Original and read back float values mismatch\n0x%X 0x%X\n", originalValue, readBackValue);
            throw new RuntimeException(errorMessage);
        } else {
            System.out.printf("Written and read back float values match\n0x%X 0x%X\n", originalValue, readBackValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7398().testFloat();
    }
}

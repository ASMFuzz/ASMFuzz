public class MyJVMTest_9213 {

    void testDouble() {
        long originalValue = 0xFFF0000000000001L;
        long readBackValue = Double.doubleToRawLongBits(Double.longBitsToDouble(originalValue));
        if (originalValue != readBackValue) {
            String errorMessage = String.format("Original and read back double values mismatch\n0x%X 0x%X\n", originalValue, readBackValue);
            throw new RuntimeException(errorMessage);
        } else {
            System.out.printf("Written and read back double values match\n0x%X 0x%X\n", originalValue, readBackValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9213().testDouble();
    }
}

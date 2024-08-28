public class MyJVMTest_9643 {

    int testToUnsignedLong() {
        int errors = 0;
        int[] data = { 0, 1, 2, 3, 0x1234_5678, 0x8000_0000, 0x8000_0001, 0x8000_0002, 0x8000_0003, 0x8765_4321, 0xFFFF_FFFE, 0xFFFF_FFFF };
        for (int datum : data) {
            long result = Integer.toUnsignedLong(datum);
            if ((result & 0xffff_ffff_0000_0000L) != 0L) {
                errors++;
                System.err.printf("High bits set converting 0x%x to 0x%x%n", datum, result);
            }
            int lowOrder = (int) (result & 0x0000_0000_ffff_ffffL);
            if (lowOrder != datum) {
                errors++;
                System.err.printf("Low bits not preserved converting 0x%x to 0x%x%n", datum, result);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9643().testToUnsignedLong());
    }
}

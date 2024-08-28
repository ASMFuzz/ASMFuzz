public class MyJVMTest_13650 {

    int testByteToUnsignedInt() {
        int errors = 0;
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            byte datum = (byte) i;
            int ui = Byte.toUnsignedInt(datum);
            if ((ui & (~0xff)) != 0 || ((byte) ui != datum)) {
                errors++;
                System.err.printf("Bad conversion of byte %d to unsigned int %d%n", datum, ui);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13650().testByteToUnsignedInt());
    }
}

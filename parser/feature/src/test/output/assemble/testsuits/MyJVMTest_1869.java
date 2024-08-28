public class MyJVMTest_1869 {

    int testRoundtrip() {
        int errors = 0;
        int[] data = { -1, 0, 1 };
        for (int datum : data) {
            if (Integer.parseUnsignedInt(Integer.toBinaryString(datum), 2) != datum) {
                errors++;
                System.err.println("Bad binary roundtrip conversion of " + datum);
            }
            if (Integer.parseUnsignedInt(Integer.toOctalString(datum), 8) != datum) {
                errors++;
                System.err.println("Bad octal roundtrip conversion of " + datum);
            }
            if (Integer.parseUnsignedInt(Integer.toHexString(datum), 16) != datum) {
                errors++;
                System.err.println("Bad hex roundtrip conversion of " + datum);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1869().testRoundtrip());
    }
}

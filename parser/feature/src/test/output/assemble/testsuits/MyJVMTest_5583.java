public class MyJVMTest_5583 {

    int testShortToUnsignedInt() {
        int errors = 0;
        for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
            short datum = (short) i;
            int ui = Short.toUnsignedInt(datum);
            if ((ui & (~0xffff)) != 0 || ((short) ui != datum)) {
                errors++;
                System.err.printf("Bad conversion of short %d to unsigned int %d%n", datum, ui);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5583().testShortToUnsignedInt());
    }
}

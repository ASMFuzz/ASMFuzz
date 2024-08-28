public class MyJVMTest_15210 {

    boolean verifyShortCaching() {
        boolean cached = true;
        Short[] results = new Short[-(-128) + 127 + 1];
        for (int i = 0; i < results.length; i++) results[i] = (short) (i - 128);
        for (int i = 0; i < results.length; i++) {
            Short S = (short) (i - 128);
            if (S != results[i]) {
                cached = false;
                System.err.println("Short value " + S + " is not cached appropriately.");
            }
        }
        for (int i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++) {
            Short S;
            S = (short) i;
            if (S.shortValue() != i) {
                cached = false;
                System.err.println("Erroneous autoboxing conversion for " + "short value " + i + " .");
            }
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15210().verifyShortCaching());
    }
}

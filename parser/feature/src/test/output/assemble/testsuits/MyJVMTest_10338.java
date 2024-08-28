public class MyJVMTest_10338 {

    boolean verifyIntegerCaching() {
        boolean cached = true;
        Integer[] results = new Integer[-(-128) + 127 + 1];
        for (int i = 0; i < results.length; i++) results[i] = (i - 128);
        for (int i = 0; i < results.length; i++) {
            Integer I = (i - 128);
            if (I != results[i]) {
                cached = false;
                System.err.println("Integer value " + I + " is not cached appropriately.");
            }
        }
        for (int i = -256; i < 255; i++) {
            Integer I;
            I = i;
            if (I.intValue() != i) {
                cached = false;
                System.err.println("Erroneous autoboxing conversion for " + "int value " + i + " .");
            }
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10338().verifyIntegerCaching());
    }
}

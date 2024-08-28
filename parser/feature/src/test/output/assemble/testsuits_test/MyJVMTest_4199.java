public class MyJVMTest_4199 {

    boolean verifyLongCaching() {
        boolean cached = true;
        Long[] results = new Long[-(-128) + 127 + 1];
        for (int i = 0; i < results.length; i++) results[i] = (long) (i - 128);
        for (int i = 0; i < results.length; i++) {
            Long L = (long) (i - 128);
            if (L != results[i]) {
                cached = false;
                System.err.println("Integer value " + L + " is not cached appropriately.");
            }
        }
        for (int i = -256; i < 255; i++) {
            Integer L;
            L = i;
            if (L.longValue() != i) {
                cached = false;
                System.err.println("Erroneous autoboxing conversion for " + "int value " + i + " .");
            }
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4199().verifyLongCaching());
    }
}

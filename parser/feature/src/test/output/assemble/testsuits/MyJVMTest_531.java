public class MyJVMTest_531 {

    boolean verifyCharacterCaching() {
        boolean cached = true;
        Character[] results = new Character[127 + 1];
        for (int i = 0; i < results.length; i++) results[i] = (char) i;
        for (int i = 0; i < results.length; i++) {
            Character C = (char) i;
            if (C != results[i]) {
                cached = false;
                System.err.println("Char value " + C + " is not cached appropriately.");
            }
        }
        for (int i = Character.MIN_VALUE; i < Character.MAX_VALUE; i++) {
            Character C;
            C = (char) i;
            if (C.charValue() != i) {
                cached = false;
                System.err.println("Erroneous autoboxing conversion for " + "char value " + i + " .");
            }
        }
        return cached;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_531().verifyCharacterCaching());
    }
}

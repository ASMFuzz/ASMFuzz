public class MyJVMTest_14127 {

    static short[] a = { 5466, 17854, 2407, -32768, -15184, -32768, 0, 0, 0, 0 };

    static Short ibc = new Short((short) 1);

    short sumc2(short[] a) {
        Short result1 = 1;
        Short result2 = ibc;
        for (Short i : a) {
            result1 = (short) (result1 + i);
            result2 = (short) (result2 + i + ibc);
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14127().sumc2(a));
    }
}

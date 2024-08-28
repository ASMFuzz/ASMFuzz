public class MyJVMTest_8532 {

    static short[] a = { 32767, 5766, -32768, 0, -32768, 0, 1694, -32768, -32768, 0 };

    static Short ibc = new Short((short) 1);

    short sumc(short[] a) {
        Short result = ibc;
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8532().sumc(a));
    }
}

public class MyJVMTest_18123 {

    static short[] a = { 13043, 32767, 0, 0, -32768, 9100, 0, 0, 7819, -32768 };

    static Short ibc = new Short((short) 1);

    short sumc(short[] a) {
        Short result = ibc;
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18123().sumc(a));
    }
}

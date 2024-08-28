public class MyJVMTest_17457 {

    static short i = -32768;

    static Short ib1 = 32767;

    short simplep2(short i, Short ib1) {
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17457().simplep2(i, ib1));
    }
}

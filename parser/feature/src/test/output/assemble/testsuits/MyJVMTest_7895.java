public class MyJVMTest_7895 {

    static short i = -7836;

    static Short ib1 = -32768;

    short simplep2(short i, Short ib1) {
        Short ib2 = Short.valueOf((short) (i + 1));
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7895().simplep2(i, ib1));
    }
}

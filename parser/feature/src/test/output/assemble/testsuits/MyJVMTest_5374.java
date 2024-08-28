public class MyJVMTest_5374 {

    static short i = -30862;

    static Short ibc = new Short((short) 1);

    short testc2(short i) {
        Short ib1 = ibc;
        Short ib2 = (short) (i + 1);
        if ((i & 1) == 0) {
            ib1 = (short) (ibc + 1);
            ib2 = (short) (i + 2);
        }
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5374().testc2(i));
    }
}

public class MyJVMTest_8374 {

    static short i = 32767;

    short testm2(short i) {
        Short ib1 = new Short(i);
        Short ib2 = (short) (i + 1);
        if ((i & 1) == 0) {
            ib1 = new Short((short) (i + 1));
            ib2 = (short) (i + 2);
        }
        return (short) (ib1 + ib2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8374().testm2(i));
    }
}

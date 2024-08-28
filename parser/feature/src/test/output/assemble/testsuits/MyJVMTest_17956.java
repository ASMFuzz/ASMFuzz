public class MyJVMTest_17956 {

    static short i = 0;

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
        System.out.println(new MyJVMTest_17956().testm2(i));
    }
}

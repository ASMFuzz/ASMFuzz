public class MyJVMTest_13832 {

    static short i = 0;

    short testm(short i) {
        Short ib = i;
        if ((i & 1) == 0)
            ib = new Short((short) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13832().testm(i));
    }
}

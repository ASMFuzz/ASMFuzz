public class MyJVMTest_4447 {

    static short i = 32767;

    short testm(short i) {
        Short ib = i;
        if ((i & 1) == 0)
            ib = new Short((short) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4447().testm(i));
    }
}

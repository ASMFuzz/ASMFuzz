public class MyJVMTest_7034 {

    static short i = 32767;

    static Short ibc = new Short((short) 1);

    short testc(short i) {
        Short ib = ibc;
        if ((i & 1) == 0)
            ib = new Short((short) (i + 1));
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7034().testc(i));
    }
}

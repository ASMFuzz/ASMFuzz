public class MyJVMTest_15582 {

    static short i = 0;

    void dummy() {
    }

    static Short ibc = new Short((short) 1);

    short simplec_deop(short i) {
        Short ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15582().simplec_deop(i));
    }
}

public class MyJVMTest_6118 {

    static short i = -32768;

    void dummy() {
    }

    static Short ibc = new Short((short) 1);

    short simplec_deop(short i) {
        Short ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6118().simplec_deop(i));
    }
}

public class MyJVMTest_18121 {

    static Byte ib = -128;

    void dummy() {
    }

    byte simplep_deop(Byte ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18121().simplep_deop(ib));
    }
}

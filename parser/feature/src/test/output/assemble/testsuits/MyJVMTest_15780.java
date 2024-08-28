public class MyJVMTest_15780 {

    static int i = 1;

    void dummy() {
    }

    static Integer ibc = new Integer(1);

    int simplec_deop(int i) {
        Integer ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15780().simplec_deop(i));
    }
}

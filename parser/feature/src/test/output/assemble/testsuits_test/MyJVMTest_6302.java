public class MyJVMTest_6302 {

    static int i = 9;

    void dummy() {
    }

    static Integer ibc = new Integer(1);

    int simplec_deop(int i) {
        Integer ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6302().simplec_deop(i));
    }
}
